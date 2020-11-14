package com.bridgelabz.basic

object StringReplacement extends App {
  //String Template
  val userMessage: String = "Hello <<UserName>>, how are you?"
  //Read User Input
  println("What's your Name?")
  val userName: String = scala.io.StdIn.readLine()
  //Input atleast 3 chars
  if (userName.length() <= 3) {
    println("Invalid username.")
  }
  else {
    //Replace all parts of the string that match with the regex
    val display = userMessage.replaceAll("<<[\\s\\S]*>>", userName)
    println(display)
  }
}