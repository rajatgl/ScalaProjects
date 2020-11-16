package com.bridgelabz.functional

import java.io.PrintWriter

object TwoDimentionalArray {
  def arrayInputFromUsers(rowCount: Int, columnCount: Int): Array[Array[Object]] = {
    val arr = Array.ofDim[Object](rowCount, columnCount)
    var choice: Int = 0
    //array input
    for (row <- 0 until rowCount) {
      for (column <- 0 until columnCount) {
        println("Select Your Choice")
        println("'1' for Integer Input")
        println("'2' for Double Input")
        println("Any for Boolean Input")
        choice = scala.io.StdIn.readInt()
        println("Array Entry For RowNumber: " + row + " & columnNumber: " + column)
        //alternative for switch in scala
        choice match {
          case 1 => arr(row)(column) = scala.io.StdIn.readInt().asInstanceOf[Object]
          case 2 => arr(row)(column) = scala.io.StdIn.readDouble().asInstanceOf[Object]
          case _ => arr(row)(column) = scala.io.StdIn.readBoolean().asInstanceOf[Object]

        }
      }
    }
    arr
  }

  def printArray(array: Array[Array[Object]]): Unit = {
    //creating a PrintWriter object
    val printWriter = new PrintWriter(System.out)
    for (row <- array) {
      for (element <- row) {
        printWriter.write(element + " ")
      }
      printWriter.write("\n")
    }
    //clearing the buffer closing the resource
    printWriter.flush()
    printWriter.close()
  }

  def main(args: Array[String]): Unit = {
    println("Enter row and column count :")
    //Reading dimensions from the arrayDimension array
    val arrayDimension = scala.io.StdIn.readLine.split(" ").map(_.trim.toInt)
    val userArray = arrayInputFromUsers(arrayDimension(0), arrayDimension(1))
    //printing out the required array output
    println("Array:")
    printArray(userArray)
  }
}
