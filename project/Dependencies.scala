import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
  lazy val cats = "org.typelevel" %% "cats" % "0.9.0" withSources () withJavadoc ()
  lazy val graphs = "org.scala-graph" %% "graph-core" % "1.11.5"
}
