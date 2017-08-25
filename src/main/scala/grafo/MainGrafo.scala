package grafo


object MainGrafo extends App{

  val matriz = Validaciones.fromTXT.fold(err => println(s"$err"),
    m => GraphSearch.LoadMatriz(m,"A","D"))

  println(s"/////////////: $matriz")

  /*val graph = GraphSearch.Load("graph","A","C")
  println(s"***** ${graph}")*/
}
