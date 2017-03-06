name := "rock–paper–scissors"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

mainClass in Compile := Some("com.gnosly.adapter.GameEngine")