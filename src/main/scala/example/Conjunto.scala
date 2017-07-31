package example

trait Operaciones[T]{
  def ∪(conjunto: Conjunto[T]): T
  def ∩(conjunto: Conjunto[T]): T
  def ~(conjunto: Conjunto[T]): T
}

class Conjunto[T](lista: T) extends Operaciones[T]{
  override def ∪(conjunto: Conjunto[T]): T = ???

  override def ∩(conjunto: Conjunto[T]): T = ???

  override def ~(conjunto: Conjunto[T]): T = ???
}
