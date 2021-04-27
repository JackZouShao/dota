package com.alex.scala

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{DataFrame, SparkSession}

object RollupMonthIncomeDSL {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName(this.getClass.getSimpleName)
      .master("local[*]")
      .getOrCreate()

    // 对csv文件，返回的是DateFrame
    val orders:DataFrame  = spark.read
      .option("header", "true") // 表头
      .option("inferSchema", "true") // 推断类型
      .csv("file///D:csv")
    orders.printSchema()
    orders.show()

    // 导入 隐试转化换
    import spark.implicits._
    import org.apache.spark.sql.functions._
    // 按照sid、 月份进行聚合，sum(money)
    // ￥代表将字符串变成列名
    val result = orders.groupBy($"aid", date_format($"dt", "yyyy-MM"))
      .agg(sum("money") as "mth_sales")
      .select('sid, 'mth, 'mth_sales, sum('mth_sales) over(Window.partitionBy('sid).orderBy('mth).rowsBetween(Window.unboundedPreceding, Window.currentRow)) as("rollup_sales"))
    result.show()
  }
}
