package Fruits

import FruitsTypes.{FruitsType, Large, Oval}

class Pineapple extends Fruit {

  override var fruitName: String = "Pineapple"
  override var fruitsTypes: Array[FruitsType] = Array(new Oval() ,new Large())
  override def copy(): Fruit = {
    var fruit = new Pineapple()
    fruit.setWeight(this.weight)
    fruit
  }
}
