package com.bridgelabz.basic

object HarmonicValue extends App {
  print("Enter N: ")
  var value = scala.io.StdIn.readInt()

  def isValidInput(input: Int): Boolean = {
    input > 0
  }

  def harmonicResult(input: Int): Float = {
    var sum: Float = 0
    for (i <- 1 to input) {
      sum += 1f / i
    }
    sum
  }
  if(isValidInput(value))
    println("Harmonic Value: "+harmonicResult(value))
  else
    println("Invalid Input")
}
