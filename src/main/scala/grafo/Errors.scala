package grafo

trait Error{
  def mensaje: String
}

case class IngreseNodos(mensaje:String = "Ingrese Nodos para comparar su distancia") extends Error
case class ImposibleLeerDimensiones(mensaje: String = "Imposible leer Dimensiones")
  extends Error
case class ArchivoConValoresDiferentesAInt(mensaje: String = "El archivo tiene valores diferentes a Enteros")
  extends Error
case class DimensionesIncorrectas(mensaje: String)
  extends Error
case class DistanciaHaciaElMismoNodoIncorrecta(mensaje: String)
  extends Error


