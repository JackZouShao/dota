package com.alex.scala

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * 连续三天登陆用户
 */
object USerContinuedLoginSQL {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName(this.getClass.getSimpleName)
      .master("local[*]")
      .getOrCreate()

    // 读取文件到spark
    val access: DataFrame= spark.read.option("header", "true")
      .csv("file:///Users/access.csv")

    access.createTempView("v_assess_log")

    // SQL
    spark.sql(
      s"""
        |SELECT
        |  uid,
        |  count(1)
        |  MIN(dt) start_date,
        |  MAX(dt) end_date,
        |  COUNT(1) counts
        |FROM
        |(
        |  SELECT
        |    utd,
        |    dt,
        |    DATE_SUB(dt, rn) dif
        |    FROM
        |    (
        |      SELECT
        |        uid,
        |        dt,
        |        ROW_NUMBER() OVER(PARTITION BY uid ORDER BY dt ASC) rn
        |      FROM v_access_log
        |    ) GROUP BY uid, dif
        |)
        |GROUP BY uid, dif HAVING counts >=$d
        |
        |""".stripMargin)
  }

}
