package Fruits
import FruitsTypes.{FruitsType, Oval}

class Mango extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Oval() )
  override def copy(): Fruit = {
    val fruit = new Mango()
    fruit.setWeight(this.weight)
    fruit
  }
}
