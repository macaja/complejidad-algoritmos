package grafo

class Graph {

  var vertices = Set[Vertice]()
  var aristas = List[Arista]()
  var verticesMap = Map[Vertice,List[Vertice]]()

  def addVertice(v: Vertice) = vertices = vertices + v

  def addArista(a: Arista) = {
    aristas = a :: aristas
    verticesMap += a.node1 -> (a.node2::verticesMap.getOrElse(a.node1, Nil))
  }
  override def toString = verticesMap.toString
}

case class Vertice(id: String, distancia: Int = 0){
  override def toString = s"${id}"
}

case class Arista(node1: Vertice, node2: Vertice, distancia: Int = 0)
