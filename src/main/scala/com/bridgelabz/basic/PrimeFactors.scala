package com.bridgelabz.basic

object PrimeFactors extends App {
  println("Enter N:")
  var number = scala.io.StdIn.readInt()

  def isValidInput(): Boolean = {
    number > 1
  }

  def isPrime(input: Int): Boolean = {
    for (i <- 2 until input) {
      if (input % i == 0)
        return false
    }

    true
  }

  def primeFactors(input: Int): Unit = {
    for (i <- 2 to input) {
      if (input % i == 0 && isPrime(i)) {
        print(i + " ")
      }
    }
  }

  if (isValidInput())
    primeFactors(number)
  else
    println("Invalid Number")
}
