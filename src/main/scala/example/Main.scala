package example

object Main extends App{
  println("Operaciones básicas sobre conjuntos")

  implicit val universo = UniversoEnteros

  val A = Conjunto[Int](lista = List(1,2,3,4,5))

  val B = Conjunto[Int](lista = List(1,2,3,4,5,6,7))

/*  val sA = Conjunto[String](lista = List("1","2","3","4","5"))

  val sB = Conjunto[String](lista = List("1","2","3","4","5","6","7"))*/

  println(s"La union de los conjuntos es:${(A ∪ B).elementos}")
  println(s"La intersección de los conjuntos es:${(A ∩ B).elementos}")
  println(s"El complemento de A es:${(~A).elementos}")
  println(s"De Morgan ~(A U B) => ${(~(A ∪ B)).elementos} es igual a ~A ∩ ~B => ${(~A ∩ ~B).elementos}")
  println(((A ∪ B) ∩ (A ∩ B)).elementos)

 // println(sA ∪ sB)
}

