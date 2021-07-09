package Fruits

import FruitsTypes.{FruitsType, Large}

class Pumpkin extends Fruit {

  override var fruitName: String = "Pumpkin"
  override var fruitsTypes: Array[FruitsType] = Array(new Large())
  override def copy(): Fruit = {
    var fruit = new Pumpkin()
    fruit.setWeight(this.weight)
    fruit
  }

}
