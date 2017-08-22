package grafo.conectivity

import grafo.{Graph, Loader, Vertice}
import grafo.search.GraphTraversal


object ConnectedComponents {
  val graphTraversal = GraphTraversal

  def work(fileName: String)={
    val g = Loader.loadGraphFromFile(fileName)
    //println(connectedComponents(g,g.vertices.toList).map(x => x._1 + " -> " + x._2.mkString(",")).mkString("\n"))
    //println(reversePostOrder(g))
    println(reversePostOrder(g.reverse))
    println(stronglyConnectedComponents(g,reversePostOrder(g.reverse)).map(_.mkString(",")).mkString("\n"))
  }

  def connectedComponents(g: Graph, unmarkedList: List[Vertice], i: Int = 0):
  List[(Int, List[Vertice])] = unmarkedList match {
    case Nil => Nil
    case head :: tail =>
      val cc: List[Vertice] = graphTraversal.preOrderDFS(g, g.vertices, List(head))
      (i, cc) :: connectedComponents(g, unmarkedList diff cc, i + 1)
  }

  /*def stronglyConnectedComponents(g:Graph):List[List[Vertice]]
  = stronglyConnectedComponents2(g,topologicalSort(g.reverse))*/

  def stronglyConnectedComponents(g:Graph,vertexOrder:List[Vertice]):List[List[Vertice]] = vertexOrder match {
    case Nil => List()
    case head::tail => val sccList = graphTraversal.preOrderDFS(g,vertexOrder.toSet,List(head))
      sccList::stronglyConnectedComponents(g,vertexOrder diff sccList)
  }

  def reversePostOrder(g: Graph) = fullPostOrderDFS(g, g.vertices.toList).reverse

  def fullPostOrderDFS(g: Graph, unmarkedList: List[Vertice]): List[Vertice] = unmarkedList match {
    case Nil => Nil
    case head :: tail =>
      val markedList = graphTraversal.postOrderDFS(g, unmarkedList.toSet,List(head))
      markedList ::: fullPostOrderDFS(g, unmarkedList diff markedList)
  }
}
