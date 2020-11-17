package com.bridgelabz.functional

object EucledianDistance {

  def distance(x:Int, y:Int):Double = {
    Math.sqrt(Math.pow(x,2) + Math.pow(y,2))
  }

  def inputCoordinates():Array[Int] = {
    val coordinates = Array.ofDim[Int](2)
    print("Enter X: ")
    coordinates(0) = scala.io.StdIn.readInt()
    print("Enter Y: ")
    coordinates(1) = scala.io.StdIn.readInt()
    coordinates
  }

  def main(args: Array[String]): Unit = {
    val coordinates: Array[Int] = inputCoordinates()
    println("Euclidean Distance: " + distance(coordinates(0), coordinates(1)))
  }
}
