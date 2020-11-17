package com.bridgelabz.logical

import java.util.Date

object StopWatch {

  /**
   *
   * @return  Time Elapsed between user inputs in milliseconds
   */
  def getTimeElapsed: Long = {

    println("Enter anything to start the stopwatch.")
    scala.io.StdIn.readLine()

    val startTime = new Date().getTime

    println("Enter anything to stop the stopwatch.")
    scala.io.StdIn.readLine()

    val endTime = new Date().getTime

    endTime - startTime
  }

  def main(args: Array[String]): Unit = {

    println("Time Elapsed (in seconds): " + getTimeElapsed.toDouble/1000)
  }
}

