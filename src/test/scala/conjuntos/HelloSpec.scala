package conjuntos

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Main object" should "do a union between two sets" in {
    implicit val universo = new Universo[Int](list = (1 to 10).toList)
    val c1 = new Conjunto[Int](List(1,2,3))
    val c2 = new Conjunto[Int](List(1,2,3,4,5))
  }
}
