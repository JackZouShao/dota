package com.alex.scala

import org.apache.spark.sql.SparkSession

object ContinuedIncomeSQL {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName(this.getClass.getSimpleName)
      .master("local[*]")
      .getOrCreate()

    // 对csv文件，返回的是DateFrame
    val orders  = spark.read
      .option("header", "true") // 表头
      .option("inferSchema", "true") // 推断类型
      .csv("file///D:csv")
    orders.printSchema()
    orders.show()

    val sales = spark.sql(
      s"""
         |SELECT
         |    sid,
         |    dt,
         |    MIN(dt) start_date,
         |    MAX(dt) end_state,
         |    COUNT ("*") counts, # 次数
         |    SUM(daily_sales) total_sales #金额
         |FROM
         |(
         |    SELECT
         |        sid,
         |        dt,
         |        daily_sales,
         |        DATE_SUB(dt, rn) dif
         |    FROM
         |    (
         |        SELECT
         |            sid,
         |            dt,
         |            daily_sales,
         |            ROW_NUMBER() OVER(PARTITION BY sid ORDER BY dt ASC) rn
         |        FROM
         |            (
         |                -- 如果有二月份的要过滤， 应该在此过滤用WHERE
         |                SELECT
         |                    sid,
         |                    dt,
         |                    SUM(money) daily_sales
         |                FROM v_orders GROUP BY sid, dt
         |            )
         |    ) t1
         |)
         |t2 GROUP BY sid, dif HAVING  total_sales > 5000
         |""".stripMargin)

    sales.show()
  }
}
