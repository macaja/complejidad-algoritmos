package grafo

import scala.io.Source

object Loader {

  def loadGraphFromFile(fileName: String): Graph = {

    val graph = new Graph()
    //Read a line from the file for eg. A : B C denoting A is connected to B and C
    for (line <- Source.fromFile(fileName).getLines()) {
      val arr = line.trim.split(":") //Split the line into two using the delimiter ':"
      graph.addVertice(Vertice(arr(0))) //Add the vertex A
      if (arr.length > 1)
        for (e <- arr(1).trim.split("\\s+")){
          val node =  e.trim.split("/")
          graph.addArista(
            Arista(
              node1=Vertice(arr(0)),
              node2=Vertice(node(0)),
              distancia = node(1).toInt)
          ) //Add the edge A -> B and A -> C
        }
    }
    graph
  }
}
