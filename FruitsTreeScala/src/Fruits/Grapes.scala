package Fruits

import FruitsTypes.{ FruitsType, Tiny}

class Grapes extends Fruit {

  override var fruitName: String = "Grapes"
  override var fruitsTypes: Array[FruitsType] = Array(new Tiny())
  override def copy(): Fruit = {
    var fruit = new Grapes()
    fruit.setWeight(this.weight)
    fruit
  }
}
