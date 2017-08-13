package grafo

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.Try

object Validaciones {

  type Matriz = List[List[Int]]

  def fromTXT: Either[String, Matriz] = {
    var mutable: ArrayBuffer[List[Int]] = ArrayBuffer.empty
    val src = Source.fromFile("matriz.txt")
    var dimension = 0
    println("Ingrese las dimensiones de la matriz")
    Try(Console.readInt).fold(
      _ => println(ImposibleLeerDimensiones().mensaje),
      dms =>
        {
          dimension = dms
          for ((line,index) <- src.getLines.zipWithIndex) {
            Try(
              line.split(" ").map(_.toInt).toList)
              .fold(
                _ => println(ArchivoConValoresDiferentesAInt().mensaje),
                validateLineDimension(_,dms)
                  .fold(error => println(error.mensaje),validateDistanciaAUnMismoNodo(_,index)
                    .fold(error => println(error.mensaje),mutable.append(_))
                  )
              )
          }
        }
    )
    src.close
    mutable.exists(_.size.equals(dimension)) match {
      case false => Left("FIN POR ERRORES")
      case true => Right(mutable.toList)
    }
  }

  private def validateLineDimension(lista: List[Int], dimension: Int): Either[Error,List[Int]] =
    lista.size.equals(dimension) match {
    case false => Left(DimensionesIncorrectas(mensaje = s"La dimension de la lista $lista no coincide con la dimensión ingresada $dimension"))
    case true => Right(lista)
  }

  private def validateDistanciaAUnMismoNodo(lista:List[Int], index: Int): Either[Error, List[Int]] = {
    lista(index).equals(0) match {
      case false => Left(DistanciaHaciaElMismoNodoIncorrecta(mensaje = s"La distancia hacia el mismo nodo en la linea ${index} no es igual a 0"))
      case true => Right(lista)
    }

  }

}

/*
def fromTXT2: Either[String, Matriz] = {
  var mutable: ArrayBuffer[List[Int]] = ArrayBuffer.empty
  val src = Source.fromFile("matriz.txt")
  var dimension = 0
  println("Ingrese las dimensiones de la matriz")
  Try(Console.readInt).fold(
    _ => println("Imposible leer dimensiones"),
    dms =>
    {
      dimension = dms
      for ((line,index) <- src.getLines.zipWithIndex) {
        for{
          listaLeida <- Try(line.split(" ").map(_.toInt).toList)
            .fold[Either[Error,List[Int]]](_ => Left(ArchivoConValoresDiferentesAInt()),Right(_))
          validDimension <- validateLineDimension(listaLeida,dms)
          validDistancia <- validateDistanciaAUnMismoNodo(validDimension,index)
        }yield {
          mutable.append(validDimension)
          validDimension
        }
      }
    }
  )
  src.close
  mutable.exists(_.size.equals(dimension)) match {
    case false => Left("FIN POR ERRORES")
    case true => Right(mutable.toList)
  }
}*/

