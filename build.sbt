name := "ncurses"

version := "0.2.6"

description := "Scala Native bindings for the GNU Ncurses C library"

scalaVersion := "3.6.3"

enablePlugins(ScalaNativePlugin)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:existentials",
)

organization := "io.github.edadma"

Global / onChangedBuildSource := ReloadOnSourceChanges

licenses := Seq("ISC" -> url("https://opensource.org/licenses/ISC"))

homepage := Some(url("https://github.com/edadma/" + name.value))

//publishTo := sonatypePublishToBundle.value
//  {
//  val nexus = "https://s01.oss.sonatype.org/"
//  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
//  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
//}

//sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
//
//sonatypeCredentialHost := "s01.oss.sonatype.org"

publishMavenStyle := true

Test / publishArtifact := false
