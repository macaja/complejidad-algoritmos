package grafo

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.Try

object Validaciones {

  def fromTXT: List[List[Int]] = {
    var mutable: ArrayBuffer[List[Int]] = ArrayBuffer.empty
    val src = Source.fromFile("matriz.txt")
    println("Ingrese las dimensiones de la matriz")
    Try(Console.readInt).fold(
      _ => println("Imposible leer dimensiones"),
      dms =>
        for (line <- src.getLines) {
          Try(
            line.split(" ").map(_.toInt).toList)
            .fold(
              _ => println(s"Some values are not integer in line $line"),
              validateLineDimension(_,dms)
                .fold(println(_),mutable.append(_))
            )
        }
    )
    mutable.toList
  }

  private def validateLineDimension(lista: List[Int], dimension: Int): Either[String,List[Int]] =
    lista.size.equals(dimension) match {
    case false => Left(s"Las dimensiones de la lista $lista no coinciden con las dimensiones ingresadas.")
    case true => Right(lista)
  }

}
