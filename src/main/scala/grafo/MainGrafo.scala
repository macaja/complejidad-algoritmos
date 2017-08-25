package grafo


object MainGrafo extends App{


  /*val graph = GraphSearch.Load("graph","A","C")
  println(s"***** ${graph}")*/

  val matriz = Validaciones.fromTXT.fold(err => err,
    m => {
      val c = Loader.buildGraph(m)
      val validateNodes = Validaciones.readNodesCompare(c._2)
      if(validateNodes._2){
        GraphSearch.searchDistance(c._1,validateNodes._1.head,validateNodes._1.tail.head)
      }
      else{
        "Los nodos ingresados son incorrectos"
      }
    })

  println(s"/////////////: $matriz")

}
