package com.cowsunday.wordfinder

import org.scalatest.Assertions
import org.junit.Test

class SolverTest extends Assertions{

  @Test def testSolver() {
    val root = new LetterNode('a')
    val wordGraph = new WordGraph(root)
    
    wordGraph.addWord("an")
    wordGraph.addWord("ant")
    wordGraph.addWord("antler")
    
    val puzzle = List(
        "a", "a", "a", "n", 
        "a", "a", "a", "t",
        "a", "a", "l", "a",
        "a", "r", "e", "a")
        
    val mySolver = new Solver(new ValueComputer())
    val dictionary = new WordDictionary()
    dictionary.putWordGraph(wordGraph)
    
    val results = mySolver.solve(puzzle, dictionary)
    // doubles are not excluded
    assert(results(0).word == "antler")
    assert(results(1).word == "antler")
    assert(results(2).word == "ant")
    assert(results(3).word == "ant")
    assert(results(4).word == "an")
    assert(results(5).word == "an")
  }
}