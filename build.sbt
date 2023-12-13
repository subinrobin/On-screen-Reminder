import sbtassembly.AssemblyPlugin.autoImport._

name := "On-screen-Reminder"
organization := "com.self.awareness"
version := "1.0"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.17" % "test",
  "org.scalafx" %% "scalafx" % "19.0.0-R30" % "compile"
)

assemblyJarName in assembly := s"app-${version}.jar"

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

// Fork a new JVM for 'run' and 'test:run' to avoid JavaFX double initialization problems
fork := true

// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
Compile / run / mainClass := Some("com.self.awareness.controller.Start")
