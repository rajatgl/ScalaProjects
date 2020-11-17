package com.bridgelabz.functional
import com.bridgelabz.utils.Utilities
import scala.collection.mutable.ArrayBuffer

object ZeroTriplets {
  def triplets(ar: Array[Int]): ArrayBuffer[Array[Int]] = {
    val tripletsArray = ArrayBuffer[Array[Int]]()
    for (i <- ar.indices)
      for (j <- i + 1 until ar.length)
        for (k <- j + 1 until ar.length)
          if (ar(i) + ar(j) + ar(k) == 0)
            tripletsArray.addOne(Array[Int](ar(i), ar(j), ar(k)))
    tripletsArray
  }

  def main(args: Array[String]): Unit = {
    val tripletsArray = triplets(Utilities.read1DimArray())
    println("Number of triplets: " + Utilities.size(tripletsArray))
    println("\nTriplets->\n")
    Utilities.printObject(tripletsArray)
  }
}
