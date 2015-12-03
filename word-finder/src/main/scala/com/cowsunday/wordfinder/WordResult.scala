package com.cowsunday.wordfinder

class WordResult(val word: String, val value: Integer, val indexes: List[Int]) {

  override def toString(): String = {
    word
  }
}