package Fruits
import FruitsTypes.{Berry, FruitsType, Tiny}

class Blackberries extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Berry(),new Tiny())

  override def copy(): Fruit = {
    val fruit = new Blackberries()
    fruit.setWeight(this.weight)
    fruit
  }
}
