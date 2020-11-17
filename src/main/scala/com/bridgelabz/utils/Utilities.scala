package com.bridgelabz.utils
import scala.collection.mutable.ArrayBuffer
import scala.io._

object Utilities {
  def read1DimArray(): Array[Int] = {
    print("Enter Array Size: ")
    val arraySize = StdIn.readInt()
    val ar = Array.ofDim[Int](arraySize)
    println("Enter The Array:")
    for (i <- 0 until arraySize) {
      ar(i) = StdIn.readInt()
    }
    ar
  }

  def size(buffer: ArrayBuffer[Array[Int]]):Int = {
    var count = 0
    for(_ <- buffer)
      count+=1
    count
  }

  def printObject(buffer : ArrayBuffer[Array[Int]]): Unit = {
    for(array<- buffer){
      for(element <- array){
        print(element + " ")
      }
      println()
    }
  }
}
