package grafo

object MainGrafo extends App{

  /*val matriz = Validaciones.fromTXT

  println(matriz)
*/

  val graph = GraphSearch.Load("graph","A","C")
  println(s"***** ${graph}")
}
