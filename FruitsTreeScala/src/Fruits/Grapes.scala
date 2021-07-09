package Fruits

import FruitsTypes.{ FruitsType, Tiny}

class Grapes extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Tiny())
  override def copy(): Fruit = {
    val fruit = new Grapes()
    fruit.setWeight(this.weight)
    fruit
  }
}
