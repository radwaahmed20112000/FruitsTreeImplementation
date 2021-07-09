package Fruits

import FruitsTypes.{Berry, FruitsType, Tiny}

class Gooseberries extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Berry(),new Tiny())
  override def copy(): Fruit = {
    val fruit = new Gooseberries()
    fruit.setWeight(this.weight)
    fruit
  }

}
