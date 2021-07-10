package Fruits

import FruitsTypes.FruitsType

abstract class Fruit {
  protected var weight : Int = 0
  private var left : Fruit = null
  private var right : Fruit = null
  var fruitsTypes : Array[FruitsType]

  def copy():Fruit

  def getWeight: Int = weight
  def setWeight(weight: Int) {
    this.weight = weight
  }

  def getLeft: Fruit = left
  def setLeft(fruit: Fruit) {
    left = fruit
  }

  def getRight: Fruit = right
  def setRight(fruit: Fruit) {
    right = fruit
  }

  def getSubtypes : Array[FruitsType] = fruitsTypes
}
