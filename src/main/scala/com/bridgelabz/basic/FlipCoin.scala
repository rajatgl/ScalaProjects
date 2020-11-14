package com.bridgelabz.basic

object FlipCoin extends App {
  var coinTossCount: Int = 0
  println("Enter the Coinflip Count: ")
  val flipCount = scala.io.StdIn.readInt()

  def coinflip(): Int = {
    val r = scala.util.Random
    var rand = r.nextInt(2)
    coinTossCount += 1
    return rand
  }

  var i = 0
  var numberOfHeads: Int = 0
  for (i <- 1 to flipCount) {
    numberOfHeads += coinflip()
  }
  val numberOfTails: Int = flipCount - numberOfHeads
  println("Percentage for Heads: " + numberOfHeads * 100 / flipCount + "%")
  println("Percentage for Tails: " + numberOfTails * 100 / flipCount + "%")
}
