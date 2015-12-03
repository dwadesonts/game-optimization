package com.cowsunday.wordfinder

import scala.collection.immutable.SortedMap

object LetterValues {

  private var letterValues = SortedMap[Char, Int]()

  private def initLetterValues() {
    letterValues += ('a' -> 1)
    letterValues += ('b' -> 4)
    letterValues += ('c' -> 4)
    letterValues += ('d' -> 2)
    letterValues += ('e' -> 1)
    letterValues += ('f' -> 4)
    letterValues += ('g' -> 3)
    letterValues += ('h' -> 3)
    letterValues += ('i' -> 1)
    letterValues += ('j' -> 10)
    letterValues += ('k' -> 5)
    letterValues += ('l' -> 2)
    letterValues += ('m' -> 4)
    letterValues += ('n' -> 2)
    letterValues += ('o' -> 1)
    letterValues += ('p' -> 4)
    letterValues += ('q' -> 10)
    letterValues += ('r' -> 1)
    letterValues += ('s' -> 1)
    letterValues += ('t' -> 1)
    letterValues += ('u' -> 2)
    letterValues += ('v' -> 5)
    letterValues += ('w' -> 4)
    letterValues += ('x' -> 8)
    letterValues += ('y' -> 3)
    letterValues += ('z' -> 10)
  }
  
  initLetterValues
  
  def getLetterValue(letter: Char): Int = {
    letterValues(letter)
  }
  
}