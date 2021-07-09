package Fruits

import FruitsTypes.{FruitsType, Oval}

class Orange extends Fruit {

  override var fruitName: String = "Orange"
  override var fruitsTypes: Array[FruitsType] = Array(new Oval() )
  override def copy(): Fruit = {
    var fruit = new Orange()
    fruit.setWeight(this.weight)
    fruit
  }

}
