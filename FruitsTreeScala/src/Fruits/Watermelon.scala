package Fruits

import FruitsTypes.{FruitsType, Large}

class Watermelon extends Fruit {

  override var fruitName: String = "Watermelon"
  override var fruitsTypes: Array[FruitsType] = Array(new Large())
  override def copy(): Fruit = {
    var fruit = new Watermelon()
    fruit.setWeight(this.weight)
    fruit
  }

}
