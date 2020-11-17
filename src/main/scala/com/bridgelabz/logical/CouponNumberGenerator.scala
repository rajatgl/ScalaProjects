package com.bridgelabz.logical

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import com.bridgelabz.utils.Utilities

object CouponNumberGenerator {

  /**
   *
   * @return an absolute random number
   */
  def randomNumber: Long = {
    Math.abs(Random.nextLong())
  }

  /**
   *
   * @param couponNumbers   ArrayBuffer of coupon numbers
   * @param newCouponNumber new coupon number to check if it's unique
   * @return true if the new number is unique else false
   */
  def isUnique(couponNumbers: ArrayBuffer[Long], newCouponNumber: Long): Boolean = {
    for (couponNumber <- couponNumbers) {
      if (newCouponNumber == couponNumber)
        return false
    }
    true
  }

  /**
   *
   * @return Array Buffer containing list of coupon numbers passed by the user
   */
  def getInputs: ArrayBuffer[Long] = {
    println("Enter the space separated coupon numbers:")
    ArrayBuffer[Long](scala.io.StdIn.readLine().split(" ").map(_.toLong): _*)
  }

  /**
   *
   * @param couponNumbers Array Buffer containing list of coupon numbers passed by the user
   * @return number of random numbers generated to generate a unique coupon code
   */
  def generateCouponNumber(couponNumbers: ArrayBuffer[Long]): Long = {

    var randomCount: Long = 1
    var couponCode: Long = 0
    while (!isUnique(couponNumbers, {
      couponCode = randomNumber; couponCode
    })) {
      randomCount += 1
    }
    couponNumbers.addOne(couponCode)
    randomCount
  }

  def main(args: Array[String]): Unit = {
    val couponCodes = getInputs
    val randomCount = generateCouponNumber(couponCodes)
    println("Coupon Code Generated: " + couponCodes(Utilities.sizeOneDimLong(couponCodes) - 1))
    println("Number of Random Numbers Needed: " + randomCount)
  }
}
