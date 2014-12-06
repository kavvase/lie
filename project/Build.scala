import sbt.Keys._
import sbt._

object Build extends Build {
  import BuildSettings._
  import Dependencies._

  override lazy val settings = super.settings :+ {
    shellPrompt := { s =>
      (scala.Console.CYAN + "%s > " + scala.Console.RESET) format {
        Project.extract(s).currentProject.id
      }
    }
  }
  
  lazy val lie = Project("lie", file("."))
    .aggregate(
      `core`)
    .settings(basicSettings: _*)

  lazy val `core` = Project("core", file("core"))
    .settings(basicSettings: _*)
    .settings(libraryDependencies ++= compile(scalazCore) ++ test(scalazScalacheck, scalazSpecs2, specs2))

}
