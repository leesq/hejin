val CatsVersion = "1.0.1"
val CatsEffectVersion = "1.0.0-RC2"
val ScalaTestVersion = "3.0.4"

name := "hejin"

version := "0.1"

scalaVersion := "2.12.6"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % CatsVersion,
  "org.typelevel" %% "cats-effect" % CatsEffectVersion,
  "org.scalactic" %% "scalactic" % ScalaTestVersion,
  "org.scalatest" %% "scalatest" % ScalaTestVersion % Test
)
