package com.cowsunday.wordfinder

class WordGraph(val root: LetterNode) {

  def addWord(word: String) {
    if (word.charAt(0) == root.letter) {
      var currentNode = root
      word.substring(1).foreach { c =>
        val child = currentNode.getLetterNode(c)
        if (child == None) {
          val newChild = new LetterNode(c)

          currentNode.addLetterNode(newChild)
          currentNode = newChild
        } else {
          // already a child for this node, make it the current node and carry on
          currentNode = child.get
        }
      }

      // word end is denoted by the period character
      currentNode.addLetterNode(new LetterNode('.'))
    } else {
      throw new Exception("word: " + word + " does not start with root letter: " + root.letter)
    }

  }

  def isWord(word: String): Boolean = {
    if (word.charAt(0) == root.letter) {
      var currentNode = root
      var isWord = true
      word.substring(1).foreach { c =>
        if (isWord) {
          val child = currentNode.getLetterNode(c)
          if (child == None) {
            isWord = false
          } else {
            // keep searching
            currentNode = child.get
          }
        }

      }

      // word end is denoted by the period character
      // if we go through the whole word, and the final node doesn't have a word end, then its not a word
      if (isWord && (currentNode.getLetterNode('.')) != None) true else false
    } else {
      throw new Exception("word: " + word + " does not start with root letter: " + root.letter)
    }
  }

  def isWordRoot(word: String): Boolean = {
    if (word.charAt(0) == root.letter) {
      var currentNode = root
      var isWord = true
      word.substring(1).foreach { c =>
        if (isWord) {
          val child = currentNode.getLetterNode(c)
          if (child == None) {
            isWord = false
          } else {
            // keep searching
            currentNode = child.get
          }
        }

      }

      isWord
    } else {
      throw new Exception("word: " + word + " does not start with root letter: " + root.letter)
    }
  }

}