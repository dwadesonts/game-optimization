package com.cowsunday.wordfinder

import scala.collection.mutable.MutableList

class Solver(val valueComputer: ValueComputer) {

  val connectivityMatrix = createConnectivityMatrix()
  

  private def createConnectivityMatrix(): Array[Set[Int]] = {
    val matrix = Array.ofDim[Set[Int]](16)

    for (i <- 0 until 16) {

      // top row can't go up (i / 4 == 0)
      // leftmost row can't go left (i % 4 == 0)
      // rightmost row can't go right (i % 4 == 3)
      // bottom row can't go down (i / 4 == 3)
      val upLeft = if (i / 4 == 0 || i % 4 == 0) -1 else i - 5
      val up = if (i / 4 == 0) -1 else i - 4
      val upRight = if (i / 4 == 0 || i % 4 == 3) -1 else i - 3
      val left = if (i % 4 == 0) -1 else i - 1
      val right = if (i % 4 == 3) -1 else i + 1
      val downLeft = if (i % 4 == 0 || i / 4 == 3) -1 else i + 3
      val down = if (i / 4 == 3) -1 else i + 4
      val downRight = if (i / 4 == 3 || i % 4 == 3) -1 else i + 5

      val connectedSet = Set(upLeft, up, upRight, left, right, downLeft, down, downRight).filter { x => x >= 0 && x <= 15 }
      matrix(i) = connectedSet
    }

    matrix
  }

  def solve(puzzle: List[String], dictionary: WordDictionary): List[WordResult] = {
    val allWords = MutableList[WordResult]()

    for (i <- 0 until puzzle.length) {
      val visited = List[Int](i)

      getWords(puzzle(i), visited, puzzle, allWords, dictionary)
    }

    allWords.toList.sortBy { x => x.value }.reverse
  }

  def getWords(word: String, visited: List[Int], puzzle: List[String], allWords: MutableList[WordResult], dictionary: WordDictionary) {

    // visited is prepended to, so the last index visited is first in the list.
    val connectedIndexes = connectivityMatrix(visited.head)
    connectedIndexes.foreach { index =>
      if (visited.contains(index)) {
        // already been there, can't go there again
      } else {

        val newVisited = visited.+:(index)
        val newWord = word + puzzle(index)

        // determine if its a word, if so, add it to the list of WordResults
        if (dictionary.isWord(newWord)) {
          allWords += new WordResult(newWord, valueComputer.getValue(newVisited, puzzle), newVisited.reverse)
        }

        // continue searching if there are more words to find with this word root
        if (dictionary.isWordRoot(newWord)) {
          getWords(newWord, newVisited, puzzle, allWords, dictionary)  
        }
        
      }
    }

  }

}