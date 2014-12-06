import sbt._

object Dependencies {

  val scalaVersion = "2.11.4"
  val scalazVersion = "7.1.0"

  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  val scalazCore       = "org.scalaz"    %% "scalaz-core"               % scalazVersion
  val scalazScalacheck = "org.scalaz"    %% "scalaz-scalacheck-binding" % scalazVersion
  val scalazSpecs2     = "org.typelevel" %% "scalaz-specs2"             % "0.3.0"
  val specs2           = "org.specs2"    %% "specs2"                    % "2.4"

}