package com.cowsunday.wordfinder

class RoundTwoValueComputer(val doubleLetterIndexes: List[Int], val doubleWordIndex: Int) extends ValueComputer {

  override def getValue(indexes: List[Int], puzzle: List[String]): Int = {
    val value = indexes.map { x => 
      val baseLetterValue = LetterValues.getLetterValue(puzzle(x).charAt(0)) 
      if (doubleLetterIndexes.contains(x)) 2*baseLetterValue else baseLetterValue
      }.sum + getWordLengthBonus(indexes.length)
    
    if (indexes.contains(doubleWordIndex)) value * 2 else value
  }
}