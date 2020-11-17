package com.bridgelabz.logical

import scala.annotation.tailrec
import scala.util.Random
import scala.util.control.Breaks.break

object TicTacToe {
  //TicTacToe board
  val board: Array[Array[Char]] = Array[Array[Char]](Array('-', '-', '-'), Array('-', '-', '-'), Array('-', '-', '-'))

  /**
   * printBoard function to pretty print the TicTacToe Board
   */
  def printBoard: Unit = {
    println()
    for (row <- board)
      println(row.mkString("|| ", " | ", " ||"))
    println()
  }

  /**
   * make the user move to (x,y)
   */
  @tailrec
  def playUser:Unit = {
    println("Your Turn..")
    print("x: ")
    val x = scala.io.StdIn.readInt()
    print("y: ")
    val y = scala.io.StdIn.readInt()
    if(board(x)(y)=='-') {
      board(x)(y)='X'
      printBoard
    } else {
      println("Entered position isn't empty")
      playUser
    }
  }

  /**
   * make the computer move to (x,y) randomly
   */
  @tailrec
  def playComputer:Unit={
    val x = Random.nextInt(3)
    val y = Random.nextInt(3)
    if(board(x)(y)=='-') {
      println("Computer is now playing..")
      board(x)(y)='O'
      printBoard
    } else
      playComputer
  }

  /**
   * To check each row, column & diagonal
   * @return 'X' if User won; 'O' if Computer won; '-' if draw; ' ' if game not over
   */
  def isGameOver(): Char ={

    //Check all rows
    for(row<-board.indices) {
      val startCharacter = board(row)(0)
      if(startCharacter != '-') {
        var rowDone = true
        for (col <- board(row).indices) {
          if (board(row)(col) != startCharacter) {
            rowDone = false
          }
        }
        if (rowDone) {
          return startCharacter
        }
      }
    }

    //Check all columns
    for(col<-board.indices) {
      val startCharacter = board(0)(col)
      if(startCharacter != '-') {
        var colDone = true
        for (row <- 0 until 3) {
          if (board(row)(col) != startCharacter) {
            colDone = false
          }
        }
        if (colDone) {
          return startCharacter
        }
      }
    }

    //Check principal diagonal
    var startCharacter = board(0)(0)
    var diagDone = false

    if(startCharacter != '-') {
      diagDone = true;
      for (i <- 0 until 3) {
        if (board(i)(i) != startCharacter) {
          diagDone = false
        }
      }
      if (diagDone) {
        return startCharacter
      }
    }

    //Check secondary diagonal
    startCharacter = board(0)(2)

    if(startCharacter != '-') {
      diagDone = true;
      for (i <- 0 until 3) {
        if (board(i)(2 - i) != startCharacter) {
          diagDone = false
        }
      }
      if (diagDone) {
        return startCharacter
      }
    }

    //Check if no more moves to play
    var draw = true
    for(row<-board){
      for(element<-row){
        if(element == '-') {
          draw = false
        }
      }
    }

    if(draw)
      return '-'

    //In case game can  continue
    ' '
  }

  def main(args: Array[String]): Unit = {
    printBoard
    var gameParameter:Char = ' '
    while({gameParameter = isGameOver(); gameParameter} == ' '){
      playUser
      if(isGameOver() == ' ')
        playComputer
    }

    if(gameParameter == '-'){
      println("Game ended in a draw.")
    }
    else{
      println(gameParameter + " won the game!")
    }
  }
}
