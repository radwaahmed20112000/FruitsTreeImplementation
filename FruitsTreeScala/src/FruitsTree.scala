import Fruits.{Apple, Fruit}
import FruitsTypes.FruitsType


class FruitsTree extends IFruitsTree {

  private var fruit: Fruit = _
  private var fruits: Array[Fruit] = _
  private var tree: FruitsTree = _

  override def iterate(): Unit = inorderTraverse(fruit,-1)

  def inorderTraverse(fruit: Fruit ,method:Int ,Type:Fruit = null,filterFunction: (Fruit,Fruit) => Boolean = null) {
    if (fruit == null) {
      return
    }
    inorderTraverse(fruit.getLeft(),method,Type,filterFunction)
    method match {
      case -1 => print(fruit.getWeight() + " ")
      case -2 => if(filterFunction(fruit,Type)){  fruits :+= fruit }
      case _ => if(fruit.getClass.equals(Type.getClass)) { fruit.setWeight(fruit.getWeight() + method)}
        val node : Fruit = fruit.copy()
        this.tree.insert(node)
    }
    inorderTraverse(fruit.getRight(),method,Type,filterFunction)
  }


  override def filterByType(fruit: Fruit): Array[Fruit] = {
    fruits = Array()
    inorderTraverse(this.fruit,-2,fruit, checkType)
    fruits
  }

  override def filterByWeight(weight : Int): Array[Fruit] ={
    fruits = Array()
    var Type : Fruit = new Apple()
    Type.setWeight(weight)
    inorderTraverse(this.fruit,-2,Type, checkWeight)
    fruits
  }

  override def magnifyByType(fruit: Fruit, weight: Int) = {
    tree = new FruitsTree()
    inorderTraverse(this.fruit,weight,fruit)
    this.fruit = tree.fruit
//    fruits = Array()
//    inorderTraverse(this.fruit,weight,fruit)
//    for(node <- fruits){
//      deleteNode(node)
//      node.setWeight(node.getWeight() + weight)
//      insert(node)
//    }
  }

  override def findHeaviest(): Int = find(fruit,_.getRight)

  override def findLightest(): Int = find(fruit,_.getLeft)

  def find(fruit: Fruit, callback : Fruit => Fruit): Int = {
    if(callback(fruit) == null){
      return fruit.getWeight()
    }
    find(callback(fruit),callback)
  }

  def deleteNode(fruit: Fruit): Unit = {
    this.fruit = deleteRec(this.fruit, fruit)
  }

  def deleteRec(root: Fruit, fruit: Fruit): Fruit = {
    if (root == null) return root
    if (fruit.getWeight() < root.getWeight()) root.setLeft(deleteRec(root.getLeft(), fruit))
    else if (fruit.getWeight() > root.getWeight()) root.setRight(deleteRec(root.getRight(), fruit))
    else if(fruit == root){
      if (root.getLeft() == null) return root.getRight()
      else if (root.getRight() == null) return root.getLeft()
      root.setWeight(minValue(root.getRight()))
      root.setRight(deleteRec(root.getRight(), root))
    }
    root
  }

  def minValue(root: Fruit): Int = {
    var minv = root.getWeight()
    while ( {
      root.getLeft() != null
    }) {
      minv = root.getLeft().getWeight()
      this.fruit = root.getLeft()
    }
    minv
  }

  def insert(fruit: Fruit): Unit ={
    if(this.fruit == null) {
      this.fruit = fruit
      return
    }
    insert(this.fruit,fruit)
  }

  def insert(root : Fruit,fruit: Fruit): Unit ={
    if (fruit.getWeight() < root.getWeight()) {
      if(root.getLeft() == null){
        root.setLeft(fruit)
        return
      }
      insert(root.getLeft(), fruit)
    }
    else {
      if(root.getRight() == null){
        root.setRight(fruit)
        return
      }
      insert(root.getRight(), fruit)
    }
  }

  def checkWeight(fruit1: Fruit,fruit2: Fruit): Boolean = fruit1.getWeight() > fruit2.getWeight()

  def checkType(fruit1: Fruit,fruit2: Fruit): Boolean = fruit1.getClass == fruit2.getClass

}
