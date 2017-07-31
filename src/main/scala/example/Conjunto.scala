package example

trait Operaciones[T]{
  def ∪(conjunto: Conjunto[T]): Conjunto[T]
  def ∩(conjunto: Conjunto[T]): Conjunto[T]
  def unary_~[List[T]]: Conjunto[T]
}

class Conjunto[E](lista: List[E])(implicit universo: Universo[E]) extends Operaciones[E]{
  def elementos: List[E] = lista

  override def ∪(conjunto: Conjunto[E]): Conjunto[E] = new Conjunto((lista ::: conjunto.elementos).distinct)

  override def ∩(conjunto: Conjunto[E]): Conjunto[E] = new Conjunto(lista intersect conjunto.elementos)

  override def unary_~[List[E]]: Conjunto[E] = new Conjunto(universo.lista diff lista)
}

object Conjunto{
  def apply[E](lista: List[E])(implicit universo: Universo[E]): Conjunto[E] = {
    if(lista.isInstanceOf[List[Int]] && universo.lista.isInstanceOf[List[Int]]){
      println(s"SON INSTANCIAS DE INT")
      new Conjunto(lista)
    }
    else {
      new Conjunto(Nil)
    }
  }
}