package Fruits
import FruitsTypes.{Berry, FruitsType, Tiny}

class Blackberries extends Fruit {

  override var fruitName: String = "Blackberry"
  override var fruitsTypes: Array[FruitsType] = Array(new Berry(),new Tiny())
}
