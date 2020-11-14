package com.bridgelabz.basic

object FlipCoin extends App {
  //Initializing no. of tosses done to 0
  var coinTossCount: Int = 0

  //Input number of tosses to be done from user
  println("Enter the Coinflip Count: ")
  val flipCount = scala.io.StdIn.readInt()

  //Function to toss the coin: 0 for tail, 1 for head
  def coinFlip(): Int = {
    val r = scala.util.Random
    coinTossCount += 1
    r.nextInt(2)
  }

  //Use the loop to toss the coin flipCount no. of times
  var i = 0
  var numberOfHeads: Int = 0
  for (i <- 1 to flipCount) {
    numberOfHeads += coinFlip()
  }
  val numberOfTails: Int = flipCount - numberOfHeads

  //Display respective percentages
  println("Percentage for Heads: " + numberOfHeads * 100 / flipCount + "%")
  println("Percentage for Tails: " + numberOfTails * 100 / flipCount + "%")
}
