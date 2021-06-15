package Fruits

import FruitsTypes.{FruitsType, Large}

class Pumpkin extends Fruit {

  override var fruitName: String = "Pumpkin"
  override var fruitsTypes: Array[FruitsType] = Array(new Large())

}
