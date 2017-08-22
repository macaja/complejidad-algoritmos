package grafo.search

import grafo.{Graph, Loader, Vertice}

object GraphTraversal {
  def Load(fileName: String) {
    val g = Loader.loadGraphFromFile(fileName)
    //println(preOrderDFS(g, g.vertices, List(Vertex("A"))).mkString(" "))
    //println(postOrderDFS(g,g.vertices, List(Vertex("A"))).mkString(" "))
    println(s"OEEEE ${bfs(g,g.vertices, List(Vertice("A")))}")
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

  def bfs(g:Graph, unmarkedSet:Set[Vertice], queue:List[Vertice]):List[Vertice] = queue match{
    case Nil => Nil
    case head::tail => head::bfs(g,unmarkedSet - head,
      tail ++ g.verticesMap.getOrElse(head,List()).reverse intersect unmarkedSet.toList)
  }
}
