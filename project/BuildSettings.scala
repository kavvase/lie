import sbt.Keys._

object BuildSettings {

  lazy val basicSettings = Seq(
    scalaVersion := Dependencies.scalaVersion,
    scalacOptions := Seq(
      "-encoding", "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-language:_"))

}