package grafo.search

import grafo.{Graph, Loader, Vertice}

object DFS {
  def doDFS(fileName: String) {
    val g = Loader.loadGraphFromFile(fileName)
    println(preOrderDFS(g, g.vertices, List(Vertice("A"))).mkString(" "))
    println(postOrderDFS(g,g.vertices, List(Vertice("A"))).mkString(" "))
  }


  def preOrderDFS(g: Graph, unmarkedSet: Set[Vertice], vertexList: List[Vertice]): List[Vertice] = vertexList match {
    case List() => Nil
    case head :: tail => (head) :: preOrderDFS(g, unmarkedSet - head,
      g.verticesMap.getOrElse(head, List()).reverse ++ tail intersect (unmarkedSet.toList))
  }

  def postOrderDFS(g: Graph, unmarkedSet: Set[Vertice], vertexList: List[Vertice]): List[Vertice] = vertexList match {
    case List() => Nil
    case head :: tail => val visited = postOrderDFS(g, unmarkedSet - head,
      g.verticesMap.getOrElse(head, List()).reverse intersect unmarkedSet.toList) :+ head
      visited ::: postOrderDFS(g, unmarkedSet -- visited, tail diff visited)
  }
}
