import Fruits.Fruit

trait IFruitsTree {


  /**
   * a method that prints the in-order traversal of the tree
   */
  def iterate()

  /**
   * Method that prints the nodes of a given fruit type ordered by. weight.
   * For example, get an ordered list of all apples in the tree.
   */
  def filterByType(fruit : Fruit):List[Fruit]

  /**
   * Method that prints the nodes that have weight larger than the given amount ordered by wright.
   * For example, get an ordered list of all fruits in the tree that are heavier than 500 grams.
   */
  def filterByWeight(weight : Int):List[Fruit]

  /**
   * Method that increases the weight of the nodes of a given fruit type by the given amount.
   * For example, add 200 grams to all bananas in the tree.
   */
  def magnifyByType(fruit : Fruit , weight : Int)

  /**
   * Method that finds the node with the greatest weight in the tree.
   */
  def findHeaviest():Int

  /**
   * Method that finds the node with the least weight in the tree.
   */
  def findLightest(): Int
}
