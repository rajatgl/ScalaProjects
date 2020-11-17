package com.bridgelabz.functional

object WindChill {

  def windChill(temperature:Double, velocity:Double):Double = {
    35.74 + (0.6215 * temperature) + (((0.4275 * temperature) - 35.75) * Math.pow(velocity, 0.16))
  }

  def isValidInput(temperature:Double, velocity:Double):Boolean = {
    Math.abs(temperature) <= 50 && velocity <= 120 && velocity >= 3
  }

  def main(args: Array[String]): Unit = {
    val temperature: Double = scala.io.StdIn.readDouble()
    val velocity: Double = scala.io.StdIn.readDouble()

    if(!isValidInput(temperature, velocity))
      println("Invalid inputs.")
    else
      println("Wind Chill: " + windChill(temperature, velocity))
  }
}
