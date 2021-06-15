package Fruits

import FruitsTypes.{ FruitsType, Tiny}

class Grapes extends Fruit {

  override var fruitName: String = "Grapes"
  override var fruitsTypes: Array[FruitsType] = Array(new Tiny())

}
