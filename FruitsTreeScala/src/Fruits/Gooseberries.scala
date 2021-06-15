package Fruits

import FruitsTypes.{Berry, FruitsType, Tiny}

class Gooseberries extends Fruit {

  override var fruitName: String = "Gooseberry"
  override var fruitsTypes: Array[FruitsType] = Array(new Berry(),new Tiny())

}
