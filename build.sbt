val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "mandlebrot",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test",

    libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"
  )
