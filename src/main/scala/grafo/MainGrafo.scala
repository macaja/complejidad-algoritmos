package grafo

import grafo.conectivity.ConnectedComponents
import grafo.search.GraphTraversal

object MainGrafo extends App{

  /*val matriz = Validaciones.fromTXT

  println(matriz)
*/

  val graph = GraphTraversal.Load("graph")
  val graph5 = ConnectedComponents.work("graph")
  val graph2 = Loader.loadGraphFromFile("graph").toString
  val graph3 = Loader.loadGraphFromFile("graph").aristas

  println(s"GRAPH ${graph2}")
  println(s"ARISTAS ${graph3}")


}
