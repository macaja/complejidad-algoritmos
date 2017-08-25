package grafo

import scala.collection.mutable.ArrayBuffer
import scala.io.{Source, StdIn}
import scala.util.Try

object Validaciones {

  type Matriz = List[List[Int]]

  def fromTXT: Either[String, Matriz] = {
    var mutable: ArrayBuffer[List[Int]] = ArrayBuffer.empty
    val src = Source.fromFile("matriz.txt")
    var dimension = 0
    println("Ingrese las dimensiones de la matriz")
    Try(StdIn.readInt).fold(
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
    if(mutable.size == dimension){
      Right(mutable.toList)
    }else{
      Left("FIN POR ERRORES")
    }
  }
  def readNodesCompare(availableNodes:List[String]): (List[String], Boolean) = {
    println("Ingrese 2 nodos para comparar su distancia.")
    Try(StdIn.readLine).fold(
      _ => {
        println(IngreseNodos().mensaje)
        (Nil,false)
      },
      nds => {
        val input = nds.trim.split("\\s+").toList
        (input.map(_.toUpperCase), input.size.equals(2) &&
          availableNodes.contains(input.head.toUpperCase) &&
          availableNodes.contains(input.tail.head.toUpperCase))
      }
    )
  }

  private def validateLineDimension(lista: List[Int], dimension: Int): Either[Error,List[Int]] =
    lista.size.equals(dimension) match {
    case false => Left(DimensionesIncorrectas(mensaje = s"La dimension de la lista $lista no coincide con la dimensión ingresada $dimension"))
    case true => Right(lista)
  }

  private def validateDistanciaAUnMismoNodo(lista:List[Int], index: Int): Either[Error, List[Int]] = {
    lista(index).equals(0) match {
      case false => Left(DistanciaHaciaElMismoNodoIncorrecta(mensaje = s"La distancia hacia el mismo nodo en la linea ${index+1} no es igual a 0"))
      case true => Right(lista)
    }
  }
}
