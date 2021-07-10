import Fruits.{Apple, Avocado, Orange}
import FruitsTypes.Oval

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

    println("Inorder Traversal:")
    fruitsTree.iterate()
    println("")
    fruitsTree.magnifyByType(new Orange(),50)
    println("Magnify Orange with weight 50:")
    fruitsTree.iterate()
    println("")
    println("The Lightest Element in Tree:")
    println(fruitsTree.findLightest())
    println("The Heaviest Element in Tree:")
    println(fruitsTree.findHeaviest())
    println("Number of elements in list after filtering tree with Orange Type:")
    println(fruitsTree.filterByType(new Orange()).length)
    println("Magnify Avocado with weight 50:")
    fruitsTree.magnifyByType(new Avocado(), 50)
    fruitsTree.iterate()
    println("")
    println("Number of elements in list after filtering tree with weight 50:")
    println(fruitsTree.filterByWeight(50).length)

  }
}