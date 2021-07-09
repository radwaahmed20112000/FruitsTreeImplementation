package Fruits
import FruitsTypes.{FruitsType, Oval}

class Avocado extends Fruit {

  override var fruitsTypes: Array[FruitsType] = Array(new Oval())

  override def copy(): Fruit = {
    val avocado = new Avocado()
    avocado.setWeight(this.weight)
    avocado
  }
}
