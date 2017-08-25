package grafo

import grafo.Validaciones.Matriz

import scala.io.Source

object Loader {

  val abcdary = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray

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

  def buildGraph(matriz: Matriz): Graph = {
    val graph = new Graph()
    for (fila <-  matriz.indices){
      graph.addVertice(Vertice(abcdary(fila).toString))
      for (col <- matriz.indices) {
        if (matriz(fila)(col) > 0){
          graph.addArista(
            Arista(
              node1 = Vertice(abcdary(fila).toString),
              node2 = Vertice(abcdary(col).toString),
              distancia = matriz(fila)(col)
            )
          )
        }
      }
    }
    graph
  }
}
