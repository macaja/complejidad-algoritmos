package grafo

import grafo.Validaciones.Matriz

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Loader {

  val abcdary = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray

  def buildGraph(matriz: Matriz): (Graph, List[String]) = {
    val graph = new Graph()
    val usedNodes = ArrayBuffer[String]()
    for (fila <-  matriz.indices){
      usedNodes.append(abcdary(fila).toString)
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
    (graph, usedNodes.toList)
  }
}
