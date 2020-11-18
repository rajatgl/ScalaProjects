package com.bridgelabz.functional

object QuadraticRoots {

  def quadraticRoots(a:Int, b:Int, c:Int):Array[Double] = {
    val delta:Double = Math.pow(b,2) - (4 * a * c)
    val roots:Array[Double] = Array.ofDim[Double](2)

    if(delta < 0)
      println("Returning NaN as delta < 0");

    roots(0) = (-b + Math.sqrt(delta)/(2*a))
    roots(1) = (-b - Math.sqrt(delta)/(2*a))

    roots
  }

  def coefficients():Array[Int] = {
    val coeffs = Array.ofDim[Int](3)
    print("Enter A: ")
    coeffs(0) = scala.io.StdIn.readInt()
    print("Enter B: ")
    coeffs(1) = scala.io.StdIn.readInt()
    print("Enter C: ")
    coeffs(2) = scala.io.StdIn.readInt()
    coeffs
  }

  def main(args: Array[String]): Unit = {
    val coeffs = coefficients()
    println(quadraticRoots(coeffs(0), coeffs(1), coeffs(2)).mkString("Roots: (", ", ", ")"))
  }
}
