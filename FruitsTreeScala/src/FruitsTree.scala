import Fruits.{Apple, Fruit}
import FruitsTypes.FruitsType
import com.sun.tools.javac.code.TypeTag

import scala.reflect.runtime.universe.typeOf

class FruitsTree extends IFruitsTree {

  private var fruit: Fruit = _
  private var fruits: List[Fruit] = _
  private var newTree = new FruitsTree()

  override def iterate(): Unit = inorderTraverse(fruit,"iterate")(TypeTag[String])

  def inorderTraverse[A : TypeTag](fruit: Fruit ,callback: A,Type: Fruit = null): Unit = {
    if (fruit == null){
      return
    }
    inorderTraverse(fruit.getLeft(),callback,Type)
    typeOf[A] match{
      case t if t =:= typeOf[Fruit => String] =>
        if(callback.asInstanceOf[Fruit => String](fruit).equalsIgnoreCase(callback.asInstanceOf[Fruit => String](Type))) {
          fruits :+ fruit
        }
      case t if t =:= typeOf[String] => print(fruit.getWeight() + " ")
      case t if t =:= typeOf[Int] =>
        if(fruit.getClass == Type.getClass) {
          fruit.setWeight(fruit.getWeight() + callback)
        }
        newTree.insert(fruit)
    }
    inorderTraverse(fruit.getRight(),callback,Type)
  }

  override def filterByType(fruit: Fruit): List[Fruit] = {
    fruits = List()
    inorderTraverse(this.fruit, getName, fruit)(TypeTag[TypeTag[Fruit => String]])
    fruits
  }

  override def filterByWeight(weight : Int): List[Fruit] ={
    fruits = List()
    var newFruit : Fruit = new Apple()
    newFruit.setWeight(weight)
    inorderTraverse(this.fruit,getWeight,newFruit)(TypeTag[Fruit => String])
    fruits
  }

  //TODO
  override def magnifyByType(fruit: Fruit, weight: Int) {
    inorderTraverse(this.fruit,weight,fruit)(TypeTag[Int])
    newTree
  }
//start
  override def findHeaviest(): Int = find(fruit,_.getRight)

  override def findLightest(): Int = find(fruit,_.getLeft)

  def find(fruit: Fruit, callback : Fruit => Fruit): Int = {
    if(callback(fruit) == null){
      return fruit.getWeight()
    }
    find(callback(fruit),callback)
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
    else if (fruit.getWeight() > root.getWeight()) {
      if(root.getRight() == null){
        root.setRight(fruit)
        return
      }
      insert(root.getRight(), fruit)
    }
  }
//end
  def getName(fruit: Fruit): String = fruit.getName()

  def getWeight(fruit: Fruit): String = fruit.getWeight().toString

  def foo[A : TypeTag](a: A): Int = typeOf[A] match {
    case t if t =:= typeOf[Int => Int] => a.asInstanceOf[Int => Int](0)
    case t if t =:= typeOf[Boolean => Int] => a.asInstanceOf[Boolean => Int](true)
    case _ => 3
  }

  foo((i: Int) => i + 1)(TypeTag[Int => Int])
  // res0: Int = 1



}
