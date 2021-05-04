val CatsVersion       = "2.6.0"
val CatsEffectVersion = "3.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "hejin",
    version := "0.1",
    scalaVersion := "3.0.0-RC3",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"   % CatsVersion,
      "org.typelevel" %% "cats-effect" % CatsEffectVersion,
    )
  )
