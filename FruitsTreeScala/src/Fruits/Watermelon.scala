package Fruits

import FruitsTypes.{FruitsType, Large}

class Watermelon extends Fruit {

  override var fruitName: String = "Watermelon"
  override var fruitsTypes: Array[FruitsType] = Array(new Large())

}
