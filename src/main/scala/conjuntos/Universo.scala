package conjuntos

trait Universo[E]{
  def lista:List[E]
}

object UniversoEnteros extends Universo[Int]{
  val lista = (1 to 10).toList
}


object UniversoStrings extends Universo[String]{
  val lista = List("a","b","c")
}
