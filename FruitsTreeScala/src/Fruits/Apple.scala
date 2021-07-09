package Fruits
import FruitsTypes.{FruitsType, Oval}

class Apple extends Fruit{

  override var fruitName: String = "Apple"

  override var fruitsTypes: Array[FruitsType] = Array(new Oval())

  override def copy(): Fruit = {
    var apple = new Apple()
    apple.setWeight(this.weight)
    apple
  }
}
