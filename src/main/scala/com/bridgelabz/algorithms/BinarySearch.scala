package com.bridgelabz.algorithms

import java.io.FileNotFoundException

import com.bridgelabz.utils.Utilities.readFile

import scala.annotation.tailrec
import scala.reflect.io.File
import scala.util.Sorting

object BinarySearch {

  /**
   *
   * @param wordList   Array of values to be searched from
   * @param startIndex of the Array of values
   * @param endIndex   of the Array of values
   * @param searchKey  entered by the user to be search form Array
   * @return
   */
  @tailrec
  def binarySearch(wordList: Array[String], startIndex: Int, endIndex: Int, searchKey: String): Int = {
    if (startIndex > endIndex)
      return -1
    val mid = endIndex - ((endIndex - startIndex) / 2)
    if (searchKey.equals(wordList(mid)))
      mid
    else if (searchKey < wordList(mid))
      binarySearch(wordList, startIndex, mid - 1, searchKey)
    else
      binarySearch(wordList, mid + 1, endIndex, searchKey)
  }

  /**
   *
   * @param wordList Array to be sorted
   */
  def sort(wordList: Array[String]) = {
    Sorting.quickSort[String](wordList)
  }

  def main(args: Array[String]): Unit = {
    try {
      val wordList = readFile("./assets/WordList.txt")
      sort(wordList)

      println(wordList.mkString("File contains: ", ",", ""))

      println("\nEnter a word you'd like to search from the file:")
      val position = binarySearch(wordList, 0, wordList.length - 1, scala.io.StdIn.readLine().trim)

      if (position == -1)
        println("We could not find that word. Sorry!")
      else
        println("We found the word! It was at position: " + (position + 1))
    }
    catch{
      case e : FileNotFoundException => println("That file was not found. Here's the error: " + e.getClass.toString)
    }
  }
}
