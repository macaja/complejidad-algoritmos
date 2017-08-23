package grafo

import scala.io.Source

object Loader {

  def loadGraphFromFile(fileName: String): Graph = {

    val graph = new Graph()
    for (line <- Source.fromFile(fileName).getLines()) {
      val arr = line.trim.split(":")
      graph.addVertice(Vertice(arr(0)))
      if (arr.length > 1)
        for (x <- arr(1).trim.split("\\s+")){
          val node =  x.trim.split("/")
          graph.addArista(
            Arista(
              node1=Vertice(arr(0)),
              node2=Vertice(node(0)),
              distancia = node(1).toInt)
          )
        }
    }
    graph
  }
}
