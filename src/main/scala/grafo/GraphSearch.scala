package grafo

import scala.collection.mutable.ArrayBuffer

object GraphSearch {
  def Load(fileName: String, nodo1:String, nodo2:String):String = {
    val graph = Loader.loadGraphFromFile(fileName)
    val nodos = preOrderDFS(graph, graph.vertices, List(Vertice(nodo1.toUpperCase)), Vertice(nodo2.toUpperCase))
    getDistance(graph, nodos)
  }


  def preOrderDFS(g: Graph, noVisitados: Set[Vertice], verticesList: List[Vertice], vertice: Vertice): List[Vertice] ={
    verticesList match {
    case List() => {
      println(s"CASE LIST()")
      Nil
    }
    case head :: tail => if(head == vertice) {
      println(s"CASE HEAD :: TAIL IF (HEAD == VERTEXLIST.TAIL.HEAD")
      println(s"RETURN HEAD :: NILL ${head::Nil}")
      head :: Nil
    }
      else {
      println(s"ENTRY unmarketSet ${noVisitados}  vertexList${verticesList}")
      println(s"CASE HEAD :: TAIL  ${head :: tail}")
      println(s" verticesMAP = ${g.verticesMap}")
      println(s"g.verticesMap.getOrElse(head,List()) = ${g.verticesMap.getOrElse(head, List())} ")
      println(s"g.verticesMap.getOrElse(head,List()).reverse = ${g.verticesMap.getOrElse(head, List()).reverse} ")
      println(s"TAIL = ${tail}")
      println(s"UnmarketSet.toList = ${noVisitados.toList}")
      println(s"All ${g.verticesMap.getOrElse(head, List()).reverse ++ tail intersect noVisitados.toList}")
      println(s"RETURN HEAD :: preOrderDFS($g, ${noVisitados-head}, ${g.verticesMap.getOrElse(head, List()).reverse ++ tail intersect noVisitados.toList})")
      head :: preOrderDFS(g, noVisitados - head,
        g.verticesMap.getOrElse(head, List()).reverse ++ tail intersect noVisitados.toList, vertice)
      }
    }
  }

  def getDistance(graph:Graph, nodos: List[Vertice]): String = {
    var dis:ArrayBuffer[Option[Arista]] = ArrayBuffer.empty
    for (x <- 0 until nodos.size - 1){
      val ar = graph.aristas.find( a => a.node1 == nodos(x) && a.node2 == nodos(x+1))
      dis.append(ar)
    }
    val aristas = dis.toList.flatten
    s"${aristas.map(a => s"[${a.node1.toString}] ==== ${a.distancia} ===>").mkString(" ")} " +
      s"[${aristas.last.node2.toString}]" +
      s"\n " +
      s"La distancia de los nodos es: ${dis.toList.flatten.map(_.distancia).sum}"
  }

}
