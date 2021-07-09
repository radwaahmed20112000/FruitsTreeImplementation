package Fruits

import FruitsTypes.FruitsType

abstract class Fruit {
  var weight : Int = 0
  var fruitName : String
  var left : Fruit = null
  var right : Fruit = null
  var fruitsTypes : Array[FruitsType]

  def getName(): String = fruitName

  def getWeight(): Int = weight

  def setWeight(weight: Int) {
    this.weight = weight
  }

  def getLeft() : Fruit = left

  def setLeft(fruit: Fruit) {
    left = fruit
  }

  def getRight(): Fruit = right

  def setRight(fruit: Fruit) {
    right = fruit
  }
  def copy():Fruit

}
