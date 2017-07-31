package example

object Main extends App {
  println("Operaciones básicas sobre conjuntos")

  val A = new Conjunto[Int](lista = List(1,2,3,4,5))

  val B = new Conjunto[Int](lista = List(1,2,3,4,5,6,7))

  val sA = new Conjunto[String](lista = List("1","2","3","4","5"))

  val sB = new Conjunto[String](lista = List("1","2","3","4","5","6","7"))

  println(A ∪ B)
  println(sA ∪ sB)

  //println(A ~)

}

