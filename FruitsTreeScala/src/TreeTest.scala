import Fruits.{Apple, Avocado, Blueberries, Fruit, Orange}

object TreeTest  {
  def main(args: Array[String]): Unit = {
    val fruitsTree = new FruitsTree()
    val apple = new Apple()
    apple.setWeight(40)
    val orange = new Orange()
    orange.setWeight(100)
    val avocado = new Avocado()
    avocado.setWeight(50)
    val blueberry = new Blueberries()
    blueberry.setWeight(90)
    fruitsTree.insert(apple)
    fruitsTree.insert(avocado)
    fruitsTree.insert(orange)
    fruitsTree.insert(blueberry)
    fruitsTree.iterate()
//    print(lis)
  }
}