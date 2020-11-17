package com.bridgelabz.logical

import scala.annotation.tailrec
import scala.util.Random

object Gambler {
  /**
   *
   * @param stake is the stake placed by gambler
   * @param goal is the goal amount to be reached
   * @param returnParameters is the array: 1st element holds number of wins; 2nd element holds total gambles placed
   * @return True if he reached goal; False if he went broke
   */
  @tailrec
  def gamble(stake: Int, goal: Int, returnParameters: Array[Int]): Boolean = {

    //base condition
    if(stake == goal)
      return true
    else if(stake <= 0)
      return false

    var stakeNew = stake
    returnParameters(1)+=1
    if(Random.nextInt(2) == 1){
      //He gambled; and he won
      returnParameters(0)+=1
      stakeNew+=1;
    }
    else {
      stakeNew -= 1
    }

    //call recursively
    gamble(stakeNew, goal, returnParameters)
  }

  /**
   *
   * @return Array ofDim 2: 1st element is stake placed; second element is the goal set by the gambler
   */
  def getInputs:Array[Int] = {

    val inputs = Array.ofDim[Int](2)

    println("Welcome Gambler!")
    print("Enter Stake: ")
    inputs(0) = scala.io.StdIn.readInt()
    print("Enter Goal: ")
    inputs(1) = scala.io.StdIn.readInt()

    inputs
  }

  def main(args: Array[String]): Unit = {
    val inputs = getInputs
    val winParameters = Array.ofDim[Int](2)

    if(gamble(inputs(0), inputs(1), winParameters)){
      println("Gambler won!")
    }
    else{
      println("Gambler went broke!")
    }

    println("Won " + winParameters(0) + " gambles; Lost " + (winParameters(1) - winParameters(0)) + " gambles; win percent is: " + (winParameters(0) * 100 / winParameters(1)) + "%")
  }
}
