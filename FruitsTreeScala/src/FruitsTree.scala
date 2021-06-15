import Fruits.Fruit

class FruitsTree extends IFruitsTree {

  var fruit: Fruit = _
  var fruits: List[Fruit] = _

  override def iterate(fruit: Fruit): Unit = {
    if (fruit == null){
      return
    }
    iterate(fruit.getLeft())
    print(fruit.getWeight() +" ")
    iterate(fruit.getRight())
  }

  def inorderTraverse(Type: Fruit ,fruit: Fruit,callback: Fruit => String ): Unit = {
    if (fruit == null){
      return
    }
    inorderTraverse(Type,fruit.getLeft(),callback)
    if(callback(fruit).equalsIgnoreCase(callback(Type))){
      fruits :+ fruit
    }
    inorderTraverse(Type,fruit.getRight(),callback)
  }

  override def filterByType(fruit: Fruit): List[Fruit] = {
    fruits = _
    inorderTraverse(fruit,this.fruit,getName)
    return fruits
  }

  override def filterByWeight(weight : Int):List[Fruit] ={
    fruits = _
    inorderTraverse(fruit,this.fruit,getWeight)
    return fruits
  }
  //TODO
  override def magnifyByType(fruit: Fruit, weight: Int) {
    print("hi"+weight+fruit)
  }

  override def findHeaviest(): Int = find(fruit,getRight)

  override def findLightest(): Int = find(fruit,getLeft)

  def find(fruit: Fruit, callback:Fruit => Fruit): Int = {
    if(callback(fruit) == null){
      return fruit.getWeight()
    }
    find(callback(fruit),callback)
  }

  def getName(fruit: Fruit): String = fruit.getName()

  def getWeight(fruit: Fruit): String = fruit.getWeight().toString

  def getLeft(fruit: Fruit): Fruit = fruit.getLeft()

  def getRight(fruit: Fruit): Fruit = fruit.getRight()

}
