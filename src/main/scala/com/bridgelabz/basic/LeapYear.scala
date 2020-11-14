package com.bridgelabz.basic

object LeapYear extends App{

  //Input year for user
  print("Enter a Year: ")
  val year:Int = scala.io.StdIn.readInt();

  //function to calculate if the year is leap. Rules for leap year: https://www.timeanddate.com/date/leapyear.html
  def isLeapYear(year: Int):Boolean = {
    (year%4 == 0 && year%100 != 0) || year%400 == 0
  }

  //Print a message accordingly
  if(isLeapYear(year)) println("Year is leap. Extra 24 hours!! :)")
  else println("Year is not leap. You will have one less day :(")
}
