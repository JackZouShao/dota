package com.alex.scala

import org.apache.spark.sql.SparkSession

object RollupMonthIncomeSQL{
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName(this.getClass.getSimpleName)
      .master("local[*]")
      .getOrCreate()
    spark.sql(
      s"""
         |SELECT
         |    sid,
         |    mth,
         |    mth_sales,
         |    SUM(mth_sales) OVER(PARTITION BY sid ORDER BY dt ASC ) rollup_sales
         |--  SUM(mth_sales) OVER(PARTITION BY sid ORDER BY dt ASC ROWS BETWEEN UNDOUNDED PRECEIDING AND CURRENT ROW ) rollup_sales
         |FROM
         |(
         |    SELECT
         |        sid,
         |        CONCAT_WS("-", YEAR(dt) year, MONTH(dt) month) mth
         |        SUM(money) mth_sales,
         |    FROM v_orders GROUP BY sid, mth
         |)
         |""".stripMargin)
  }

}
