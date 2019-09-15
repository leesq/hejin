val CatsVersion = "2.0.0"
val CatsEffectVersion = "2.0.0"
val ScalaTestVersion = "3.0.8"

lazy val root = (project in file("."))
  .settings(
    name := "hejin",
    version := "0.1",
    scalaVersion := "2.13.0",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"   % CatsVersion,
      "org.typelevel" %% "cats-effect" % CatsEffectVersion,
      "org.scalactic" %% "scalactic"   % ScalaTestVersion,
      "org.scalatest" %% "scalatest"   % ScalaTestVersion % Test
    )
  )
