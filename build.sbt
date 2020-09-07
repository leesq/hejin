val ScalaTestVersion  = "3.2.0"
val CatsVersion       = "2.2.0"
val CatsEffectVersion = "2.1.4"
val SquantsVersion    = "1.6.0"
val JavaMoneyVersion  = "1.1"

lazy val root = (project in file("."))
  .settings(
    name := "hejin",
    version := "0.1",
    scalaVersion := "2.13.3",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"   % CatsVersion,
      "org.typelevel" %% "cats-effect" % CatsEffectVersion,
      "org.javamoney" % "moneta"       % JavaMoneyVersion,
      "org.scalatest" %% "scalatest"   % ScalaTestVersion % Test
    )
  )

scalacOptions ++= Seq(
  "-encoding",
  "utf8",
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps"
)
