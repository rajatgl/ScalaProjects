package com.bridgelabz.utils

import java.io.FileNotFoundException

import scala.collection.mutable.ArrayBuffer
import scala.io._
import scala.reflect.io.File

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

  def size(buffer: ArrayBuffer[Array[Int]]): Int = {
    var count = 0
    for (_ <- buffer)
      count += 1
    count
  }

  def sizeOneDimLong(buffer: ArrayBuffer[Long]): Int = {
    var count = 0
    for (_ <- buffer)
      count += 1
    count
  }

  def printObject(buffer: ArrayBuffer[Array[Int]]): Unit = {
    for (array <- buffer) {
      for (element <- array) {
        print(element + " ")
      }
      println()
    }
  }

  /**
   *
   * @param filePath address of the file to be read
   * @return Array for values read into the buffer
   */
  @throws(classOf[FileNotFoundException])
  def readFile(filePath: String): Array[String] = {
    val file = File(filePath)
    val reader = file.bufferedReader()
    reader.readLine().split(",").map(_.trim)
  }
}
