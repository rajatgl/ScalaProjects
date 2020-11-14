package com.bridgelabz.basic

object PowerOfTwo extends App {

  //Check if input lies between 0 and 31
  def isValidInput(input: Int):Boolean = {
    input >= 0 && input <= 31
  }

  //print the table
  def printTable(input: Int) = {
    for(power <- 0 to input){
      println("2^" + power + " = " + Math.pow(2, power))
    }
  }

  //input the number from user
  print("Enter the power: ")
  var input = scala.io.StdIn.readInt()

  //print the table if the input is valid
  if(isValidInput(input)) printTable(input)
  else println("Invalid input.");
}
