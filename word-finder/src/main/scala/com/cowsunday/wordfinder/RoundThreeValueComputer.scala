package com.cowsunday.wordfinder

class RoundThreeValueComputer(val tripleLetterIndexes: List[Int], val tripleWordIndex: Int) extends ValueComputer {

  override def getValue(indexes: List[Int], puzzle: List[String]): Int = {
    val value = indexes.map { x => 
      val baseLetterValue = LetterValues.getLetterValue(puzzle(x).charAt(0))
      if (tripleLetterIndexes.contains(x)) 3 * baseLetterValue else baseLetterValue
    }.sum + getWordLengthBonus(indexes.length)
    
    if (indexes.contains(tripleWordIndex)) value * 3 else value
  }
}