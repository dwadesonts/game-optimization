package com.cowsunday.wordfinder

import scala.collection.immutable.SortedMap
import scala.io.Source._

class WordDictionary {

  
  private var wordGraphs = SortedMap[Character, WordGraph]()

  def putWordGraph(graph: WordGraph) {
    wordGraphs = wordGraphs + (graph.root.letter -> graph)
  }
  
  def loadWords(filename: String) {
    val lines = fromFile(filename).getLines

    lines.foreach { line =>
      val wordGraph = wordGraphs.get(line.charAt(0))

      if (wordGraph == None) {
        val newWordGraph = new WordGraph(new LetterNode(line.charAt(0)))
        newWordGraph.addWord(line)
        putWordGraph(newWordGraph)
      } else {
        wordGraph.get.addWord(line)
      }
    }
  }

  def isWordRoot(word: String): Boolean = {
    val wordGraph = wordGraphs.get(word.charAt(0))

    if (wordGraph == None) {
      // ruh-roh
      return false
    } else {
      return wordGraph.get.isWordRoot(word)
    }
  }

  def isWord(word: String): Boolean = {
    val wordGraph = wordGraphs.get(word.charAt(0))

    if (wordGraph == None) {
      // ruh-roh
      return false
    } else {
      return wordGraph.get.isWord(word)
    }
  }

}