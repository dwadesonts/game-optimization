package com.cowsunday.wordfinder

import org.scalatest.Assertions
import org.junit.Test

class WordDictionaryTest extends Assertions {
  
  @Test def testLoading() {
    val myDict = new WordDictionary()
    
    myDict.loadWords("src/test/resources/wordlist.txt")
    
    assert(myDict.isWord("app"))
    assert(myDict.isWord("apple"))
    assert(myDict.isWord("animal"))
    assert(!myDict.isWord("applegate"))
  }
}