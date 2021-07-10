import Fruits.Fruit

class FruitsTree extends IFruitsTree {

  private var fruit: Fruit = _             //Root of the tree
  private var fruits: Array[Fruit] = _     //Array to hold Filtered Elements
  private var tree: FruitsTree = _         //New Tree after Magnification

  override def iterate(): Unit = inorderTraverse(fruit)

  /**
   * Recursive function to traverse through the tree and determine whether it would :
   * print tree elements , Fill list with tree nodes ,or Magnify type with weight
   */
  def inorderTraverse(fruit: Fruit ,method:Any = null ,Type:Fruit = null) {
    if (fruit == null) {
      return
    }
    inorderTraverse(fruit.getLeft,method,Type)

    method match {
      case _: String => fruits :+= fruit
      case _: Integer =>
        if(fruit.getClass.equals(Type.getClass)) {
          fruit.setWeight(fruit.getWeight + method.asInstanceOf[Int])
        }
        val node : Fruit = fruit.copy()
        this.tree.insert(node)
      case _ => print(fruit.getWeight + " ")
    }

    inorderTraverse(fruit.getRight,method,Type)
  }

  override def filterByType(fruit: Fruit): Array[Fruit] = filter(fruit)

  override def filterByWeight(weight : Int): Array[Fruit] = filter(weight)

  def filter(filterType : Any): Array[Fruit] ={
    fruits = Array()
    inorderTraverse(this.fruit,"Filter")
    filterType match {
      case _: Int => fruits = fruits.filter(_.getWeight > filterType.asInstanceOf[Int])
      case _: Fruit => fruits = fruits.filter(_.getClass.equals(filterType.asInstanceOf[Fruit].getClass))
    }
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
}
