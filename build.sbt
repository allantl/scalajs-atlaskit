organization in ThisBuild := "com.github.allantl"
scalaVersion in ThisBuild := "2.12.8"

lazy val ScalaJsReactVersion = "1.4.2"

lazy val core = project
  .in(file("core"))
  .settings(
    name := "scalajs-atlaskit",
    libraryDependencies ++= Seq(
      "com.payalabs" %%% "scalajs-react-bridge" % "0.8.0",
      "com.github.japgolly.scalajs-react" %%% "core" % ScalaJsReactVersion,
      "com.github.allantl" %%% "value-entry" % "0.2.0",
    )
  )
  .enablePlugins(ScalaJSPlugin)

lazy val dev = project
  .in(file("dev"))
  .settings(
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % ScalaJsReactVersion,
      "org.scala-js" %%% "scalajs-dom" % "0.9.6"
    ),
    npmDependencies in Compile ++= Seq(
      "react" -> "16.8.6",
      "react-dom" -> "16.8.6",
      "styled-components" -> "3.4.10",

      // Atlaskit
      "@atlaskit/button" -> "13.0.6"
    ),
  )
  .dependsOn(core)
  .aggregate(core)
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val root = project
  .in(file("."))
  .aggregate(core)
  .enablePlugins(ScalaJSPlugin)
