package Fruits
import FruitsTypes.{Berry, FruitsType, Tiny}

class Blueberries extends Fruit {
  override var fruitName: String = "Blueberry"
  override var fruitsTypes: Array[FruitsType] = Array(new Berry(),new Tiny())
  override def copy(): Fruit = {
    var fruit = new Blueberries()
    fruit.setWeight(this.weight)
    fruit
  }
}
