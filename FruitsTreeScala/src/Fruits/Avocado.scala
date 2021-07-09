package Fruits
import FruitsTypes.{FruitsType, Oval}

class Avocado extends Fruit {
  
  override var fruitName: String = "Avocado"
  override var fruitsTypes: Array[FruitsType] = Array(new Oval())

  override def copy(): Fruit = {
    var avocado = new Avocado()
    avocado.setWeight(this.weight)
    avocado
  }
}
