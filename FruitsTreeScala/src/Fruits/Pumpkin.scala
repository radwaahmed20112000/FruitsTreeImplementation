package Fruits

import FruitsTypes.{FruitsType, Large}

class Pumpkin extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Large())
  override def copy(): Fruit = {
    val fruit = new Pumpkin()
    fruit.setWeight(this.weight)
    fruit
  }

}
