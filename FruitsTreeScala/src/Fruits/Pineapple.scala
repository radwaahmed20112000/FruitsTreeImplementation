package Fruits

import FruitsTypes.{FruitsType, Large, Oval}

class Pineapple extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Oval() ,new Large())
  override def copy(): Fruit = {
    val fruit = new Pineapple()
    fruit.setWeight(this.weight)
    fruit
  }
}
