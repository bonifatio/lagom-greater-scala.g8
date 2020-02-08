organization in ThisBuild := "$organization$"
version in ThisBuild := "$version$"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.13.0"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8" % Test

lazy val `$name;format="norm"$` = (project in file("."))
  .aggregate(`$name;format="norm"$-api`, `$name;format="norm"$-impl`)

lazy val `$name;format="norm"$-api` = (project in file("$name;format="norm"$-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `$name;format="norm"$-impl` = (project in file("$name;format="norm"$-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings)
  .dependsOn(`$name;format="norm"$-api`)

