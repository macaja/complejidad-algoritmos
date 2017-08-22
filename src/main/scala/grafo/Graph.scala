package grafo

class Graph {
  //Returns a set of vertices
  var vertices = Set[Vertice]()
  //Maintains a list of edges
  var aristas = List[Arista]()
  //Maintains a map of vertices where each vertex(key) is connected to a list of vertices(value)
  var verticesMap = Map[Vertice,List[Vertice]]()


  def addVertice(v: Vertice) = vertices = vertices + v

  def addArista(e: Arista) = {
    aristas = e :: aristas
    verticesMap += e.node1 -> (e.node2::verticesMap.getOrElse(e.node1, Nil))
  }

  //Reverses the graph
  def reverse():Graph ={
    val gReverse = new Graph()
    for(v <- vertices)
      gReverse.addVertice(v)
    for(e <- aristas)
      gReverse.addArista(new Arista(e.node2,e.node1))
    gReverse
  }

  override def toString = verticesMap.toString
}

case class Vertice(id: String, distancia: Int = 0){
  override def toString = s"${id}"
}

case class Arista(node1: Vertice, node2: Vertice, distancia: Int = 0)
