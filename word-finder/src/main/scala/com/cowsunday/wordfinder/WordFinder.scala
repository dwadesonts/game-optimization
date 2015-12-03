package com.cowsunday.wordfinder

object WordFinder {
  def main(args: Array[String]) {
//    if (args.length < 1) {
//      println("requires 1 argument - puzzle - as a String of the puzzle letters from left to right")
//      System.exit(1)
//    } 
    
    //val puzzle = args(0).toCharArray().toList.map { x => x.toString() }
    val puzzle = "anwstnioedatmpos".toCharArray().toList.map { x => x.toString() }
    
    val dictionary = new WordDictionary
    for (i <- 3 to 16) {
      val filename = "/Users/dwadeson/documents/wordlists_enable/wordlist_" + i + ".txt"
      dictionary.loadWords(filename)
    }
    
    val solver = new Solver(new RoundTwoValueComputer(List(1, 12, 10), 11))
    
    val results = solver.solve(puzzle, dictionary)
    
    results.foreach { x => print(x.word + " " + x.value + " " + x.indexes + "\n") }
  }
}