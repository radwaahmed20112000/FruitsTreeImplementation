package Fruits
import FruitsTypes.{FruitsType, Oval}

class Mango extends Fruit {

  override var fruitName: String = "Mango"
  override var fruitsTypes: Array[FruitsType] = Array(new Oval() )
}
