package example

trait Operaciones[T]{
  def ∪(conjunto: Conjunto[T]): List[T]
  def ∩(conjunto: Conjunto[T]): List[T]
  //def ~[T]: List[T]
}


class Conjunto[E](lista: List[E]) extends Operaciones[E]{
  def elementos: List[E] = lista

  override def ∪(conjunto: Conjunto[E]): List[E] = (lista ::: conjunto.elementos).distinct

  override def ∩(conjunto: Conjunto[E]): List[E] = lista intersect conjunto.elementos

}
