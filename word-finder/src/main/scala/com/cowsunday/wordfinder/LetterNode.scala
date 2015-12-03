package com.cowsunday.wordfinder

import scala.collection.immutable.SortedMap

class LetterNode(val letter: Character) {

  private var children = SortedMap[Character, LetterNode]()
  
  def addLetterNode(child: LetterNode) {
    children = children + (child.letter -> child)
  }
  
  def getLetterNode(key: Character): Option[LetterNode] = {
    children get key
  }
  
  override def toString(): String = "{\"letter\":\"" + letter + "\"}"
  
  def listChildren() {
    children.values.foreach { c => print(c) }
    println()
  }
  
}