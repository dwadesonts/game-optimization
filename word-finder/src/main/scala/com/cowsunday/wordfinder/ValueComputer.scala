package com.cowsunday.wordfinder

class ValueComputer {


  def getValue(indexes: List[Int], puzzle: List[String]): Int = {
    indexes.map { x => LetterValues.getLetterValue(puzzle(x).charAt(0)) }.sum + getWordLengthBonus(indexes.length)
  }
 
  def getWordLengthBonus(length: Int): Int = {
    if (length >= 9) 20
    else if (length == 8) 15
    else if (length == 7) 10
    else if (length == 6) 6
    else if (length == 5) 3
    else 0
  }
}