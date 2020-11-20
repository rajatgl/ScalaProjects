package com.bridgelabz.algorithms

import java.io.FileNotFoundException

import com.bridgelabz.algorithms.BinarySearch.{binarySearch, sort}
import com.bridgelabz.utils.Utilities.readFile

import scala.reflect.ClassTag
import scala.util.control.Breaks
import scala.util.control.Breaks.break

/**
 * Created on 11/18/2020.
 * Class: InsertionSort.scala
 * Author: Rajat G.L.
 */
object InsertionSort {
  /**
   *
   * @param wordList array of values to be sorted
   */
  def insertionSort[A:ClassTag](wordList: Array[A])(implicit variable:A => Ordered[A]): Unit = {
    //iterating through all the wordIndices except first one
    for (wordIndex <- 1 until wordList.length) {
      var currentIndex = wordIndex
      //creating a breakable loop
      val loop = new Breaks
      loop.breakable {
        //iterating through all predecessors of currentIndex
        for (sortedIndex <- wordIndex - 1 to 0 by -1) {
          //swap if predecessor is greater than current word else break
          if (wordList(sortedIndex) > wordList(currentIndex)) {
            val temp = wordList(currentIndex)
            wordList(currentIndex) = wordList(sortedIndex)
            wordList(sortedIndex) = temp
            currentIndex -= 1
          }
          else {
            loop.break()
          }
        }
      }
    }
  }
  def main(args: Array[String]): Unit = {
    try {
      val wordList = readFile("./assets/WordList.txt")
      val numberList = readFile("./assets/NumberList.txt")

      println(wordList.mkString("File contains: ", ",", ""))
      insertionSort[String](wordList)
      println(wordList.mkString("\nAfter sorting: ", ",", "."))

      println(numberList.mkString("File contains: ", ",", ""))
      val numberArray = numberList.map(_.trim.toInt)
      insertionSort[Int](numberArray)
      println(numberArray.mkString("\nAfter sorting: ", ",", "."))
    }
    catch{
      case e : FileNotFoundException => println("That file was not found. Here's the error: " + e.getClass.toString)
    }
  }
}
