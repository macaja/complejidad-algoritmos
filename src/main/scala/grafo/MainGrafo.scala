package grafo

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object MainGrafo extends App{

  var mutable: ArrayBuffer[List[Int]] = ArrayBuffer.empty
  val filename = "matriz.txt"
  for (line <- Source.fromFile(filename).getLines) {
    mutable.append(line.split(" ").map(_.toInt).toList)
  }

  println(mutable)

  def validateLine(line: List[Int], dimension: Int): Boolean = line.size.equals(dimension)

}
