package Fruits
import FruitsTypes.{FruitsType, Oval}

class Apple extends Fruit{

  override var fruitsTypes: Array[FruitsType] = Array(new Oval())

  override def copy(): Fruit = {
    val apple = new Apple()
    apple.setWeight(this.weight)
    apple
  }
}
