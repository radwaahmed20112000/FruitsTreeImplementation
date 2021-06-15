package Fruits

import FruitsTypes.{Berry, FruitsType, Tiny}

class Elderberries extends Fruit {

  override var fruitName: String = "Elderberry"
  override var fruitsTypes: Array[FruitsType] = Array(new Berry(),new Tiny())

}
