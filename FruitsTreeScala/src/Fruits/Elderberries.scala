package Fruits

import FruitsTypes.{Berry, FruitsType, Tiny}

class Elderberries extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Berry(),new Tiny())
  override def copy(): Fruit = {
    val fruit = new Elderberries()
    fruit.setWeight(this.weight)
    fruit
  }

}
