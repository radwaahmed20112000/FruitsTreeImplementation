import Fruits.{Apple, Fruit}

class FruitsTree extends IFruitsTree {

  private var fruit: Fruit = _             //Root of the tree
  private var fruits: Array[Fruit] = _     //Array to hold Filtered Elements
  private var tree: FruitsTree = _         //New Tree after Magnification

  override def iterate(): Unit = inorderTraverse(fruit,-1)

  /**
   * Recursive function to traverse through the tree and determine whether it would :
   * print tree elements , Filter tree by weight or type ,or Magnify type with weight
   */
  def inorderTraverse(fruit: Fruit ,method:Int ,Type:Fruit = null,filterFunction: (Fruit,Fruit) => Boolean = null) {
    if (fruit == null) {
      return
    }
    inorderTraverse(fruit.getLeft,method,Type,filterFunction)

    method match {
      case -1 => print(fruit.getWeight + " ")
      case -2 => if(filterFunction(fruit,Type)){  fruits :+= fruit }
      case _ => if(fruit.getClass.equals(Type.getClass)) { fruit.setWeight(fruit.getWeight + method) }
        val node : Fruit = fruit.copy()
        this.tree.insert(node)
    }

    inorderTraverse(fruit.getRight,method,Type,filterFunction)
  }

  override def filterByType(fruit: Fruit): Array[Fruit] = {
    fruits = Array()
    inorderTraverse(this.fruit,-2,fruit, checkType)
    fruits
  }

  override def filterByWeight(weight : Int): Array[Fruit] ={
    fruits = Array()
    val Type: Fruit = new Apple()
    Type.setWeight(weight)
    inorderTraverse(this.fruit,-2,Type, checkWeight)
    fruits
  }

  override def magnifyByType(fruit: Fruit, weight: Int) {
    tree = new FruitsTree()
    inorderTraverse(this.fruit,weight,fruit)
    this.fruit = tree.fruit
  }

  override def findHeaviest(): Int = find(fruit,_.getRight)

  override def findLightest(): Int = find(fruit,_.getLeft)

  /**
   * Function to find the heaviest or lightest weight in the tree
   */
  def find(fruit: Fruit, treeFunction : Fruit => Fruit): Int = {
    if(treeFunction(fruit) == null){
      return fruit.getWeight
    }
    find(treeFunction(fruit),treeFunction)
  }

  /**
   * function to insert new fruit in the tree
   */
  def insert(fruit: Fruit): Unit ={
    if(this.fruit == null) {
      this.fruit = fruit
      return
    }
    insert(this.fruit,fruit)
  }

  def insert(root : Fruit,fruit: Fruit): Unit ={
    if (fruit.getWeight < root.getWeight) {
      if(root.getLeft == null){
        root.setLeft(fruit)
        return
      }
      insert(root.getLeft, fruit)
    }
    else {
      if(root.getRight == null){
        root.setRight(fruit)
        return
      }
      insert(root.getRight, fruit)
    }
  }

  def checkWeight(fruit1: Fruit,fruit2: Fruit): Boolean = fruit1.getWeight > fruit2.getWeight

  def checkType(fruit1: Fruit,fruit2: Fruit): Boolean = fruit1.getClass == fruit2.getClass

}
