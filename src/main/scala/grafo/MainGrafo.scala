package grafo

import grafo.Validaciones.Matriz

object MainGrafo extends App{

  val matriz: Either[String, Matriz] = Validaciones.fromTXT

  println(matriz)

}
