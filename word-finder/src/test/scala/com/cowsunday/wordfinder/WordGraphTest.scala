package com.cowsunday.wordfinder

import org.scalatest.Assertions
import org.junit.Test

class WordGraphTest extends Assertions {

  @Test def testWordGraph() {
    val root = new LetterNode('a')
    
    val myGraph = new WordGraph(root)
    
    val word1 = "app"
    val word2 = "apple"
    val word3 = "approach"
    val word4 = "approachable"
    val word5 = "angle"
    val word6 = "attire"
    
    assert(!myGraph.isWord(word1))
    assert(!myGraph.isWord(word2))
    assert(!myGraph.isWord(word3))
    assert(!myGraph.isWord(word4))
    assert(!myGraph.isWord(word5))
    assert(!myGraph.isWord(word6))
    
    myGraph.addWord(word1)
    
    // check partials
    assert(myGraph.isWord(word1))
    assert(!myGraph.isWord(word2))
    assert(!myGraph.isWord(word3))
    assert(!myGraph.isWord(word4))
    assert(!myGraph.isWord(word5))
    assert(!myGraph.isWord(word6))
    
    myGraph.addWord(word2)
    myGraph.addWord(word3)
    myGraph.addWord(word4)
    myGraph.addWord(word5)
    myGraph.addWord(word6)
    
    assert(myGraph.isWord(word1))
    assert(myGraph.isWord(word2))
    assert(myGraph.isWord(word3))
    assert(myGraph.isWord(word4))
    assert(myGraph.isWord(word5))
    assert(myGraph.isWord(word6))
    
  }
}