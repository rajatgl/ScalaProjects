package com.bridgelabz.algorithms

import java.io.FileNotFoundException

import com.bridgelabz.utils.Utilities.readFile

import scala.annotation.tailrec

/**
 * Created on 11/19/2020.
 * Class: MergeSort.scala
 * Author: Rajat G.L.
 */
object MergeSort {
  /**
   *
   * @param array of strings to be sorted
   * @param leftIndex of the array
   * @param rightIndex of the array
   * @return the sorted array
   */
  def mergeSort(array: Array[String], leftIndex: Int, rightIndex: Int): Array[String] = {
    val mid = leftIndex - ((leftIndex - rightIndex) / 2)
    if (rightIndex <= leftIndex)
      Array(array(rightIndex))
    else {
      val leftArray = mergeSort(array, leftIndex, mid)
      val rightArray = mergeSort(array, mid + 1, rightIndex)
      merge(leftArray, rightArray)
    }
  }

  /**
   *
   * @param leftArray first sorted array to be merged
   * @param rightArray second sorted array to be merged
   * @return sorted array that contains both leftArray and rightArray
   */
  def merge(leftArray: Array[String], rightArray: Array[String]): Array[String] = {
    val tempArray = Array.ofDim[String](leftArray.length + rightArray.length)
    var leftIndex = 0
    var rightIndex = 0
    var tempIndex = 0
    while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
      if (leftArray(leftIndex) > rightArray(rightIndex)) {
        tempArray(tempIndex) = rightArray(rightIndex)
        rightIndex += 1
        tempIndex += 1
      }
      else {
        tempArray(tempIndex) = leftArray(leftIndex)
        leftIndex += 1
        tempIndex += 1
      }
    }
    while (leftIndex != leftArray.length) {
      tempArray(tempIndex) = leftArray(leftIndex)
      leftIndex += 1
      tempIndex += 1
    }
    while (rightIndex != rightArray.length) {
      tempArray(tempIndex) = rightArray(rightIndex)
      rightIndex += 1
      tempIndex += 1
    }
    tempArray
  }
  def main(args: Array[String]): Unit = {
    try {
      var wordList = readFile("./assets/WordList.txt")
      println(wordList.mkString("File contains: ", ",", ""))
      wordList = mergeSort(wordList, 0, wordList.length - 1)
      println(wordList.mkString("\nAfter sorting: ", ",", "."))
    }
    catch{
      case e : FileNotFoundException => println("That file was not found. Here's the error: " + e.getClass.toString)
    }
  }
}
