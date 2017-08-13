package grafo

case class Error(message: String = "ERROR POSSIBLY IS NOT AN INT")

object MainGrafo extends App{

  val matriz: List[List[Int]] = Validaciones.fromTXT

  println(matriz)

}
