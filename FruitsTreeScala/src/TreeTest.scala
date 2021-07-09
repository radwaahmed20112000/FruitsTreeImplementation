import Fruits.{Apple, Avocado, Blueberries, Fruit, Orange}
import com.sun.tools.javac.code.TypeTag

object TreeTest  {

  def main(args: Array[String]): Unit = {
    val fruitsTree = new FruitsTree()
    val apple = new Apple()
    apple.setWeight(40)
    val orange = new Orange()
    orange.setWeight(100)
    val avocado = new Avocado()
    avocado.setWeight(50)
    val blueberry = new Orange()
    blueberry.setWeight(50)
    fruitsTree.insert(apple)
    fruitsTree.insert(avocado)
    fruitsTree.insert(orange)
    fruitsTree.insert(blueberry)
    fruitsTree.iterate()
    fruitsTree.magnifyByType(new Orange(),50)
    println("")
    fruitsTree.iterate()
    println("")
    println(fruitsTree.findLightest())
    println(fruitsTree.findHeaviest())
    println(fruitsTree.filterByType(new Orange()).length)
    fruitsTree.magnifyByType(new Avocado(), 50)
    fruitsTree.iterate()
    println("")
    println(fruitsTree.filterByWeight(50).length)

//    print(lis)
  }
}