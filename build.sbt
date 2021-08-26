name := "ncurses"

version := "0.2.2"

description := "Scala Native bindings for the GNU Ncurses C library"

scalaVersion := "2.13.6"

enablePlugins(ScalaNativePlugin)

nativeLinkStubs := true

nativeMode := "debug"

nativeLinkingOptions := Seq(s"-L/${baseDirectory.value}/native-lib")

scalacOptions ++= Seq("-deprecation",
                      "-feature",
                      "-unchecked",
                      "-language:postfixOps",
                      "-language:implicitConversions",
                      "-language:existentials")

organization := "io.github.edadma"

githubOwner := "edadma"

githubRepository := name.value

Global / onChangedBuildSource := ReloadOnSourceChanges

resolvers += Resolver.githubPackages("edadma")

Compile / mainClass := Some("Main")

//nativeLinkingOptions := Seq("-v")

licenses := Seq("ISC" -> url("https://opensource.org/licenses/ISC"))

homepage := Some(url("https://github.com/edadma/" + name.value))

publishTo := sonatypePublishToBundle.value
//  {
//  val nexus = "https://s01.oss.sonatype.org/"
//  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
//  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
//}

sonatypeRepository := "https://s01.oss.sonatype.org/service/local"

sonatypeCredentialHost := "s01.oss.sonatype.org"

publishMavenStyle := true

Test / publishArtifact := false

pomIncludeRepository := { _ =>
  false
}

pomExtra :=
  <scm>
    <url>git@github.com:edadma/{name.value}.git</url>
    <connection>scm:git:git@github.com:edadma/{name.value}.git</connection>
  </scm>
    <developers>
      <developer>
        <id>edadma</id>
        <name>Edward A Maxedon, Sr</name>
        <url>https://github.com/edadma</url>
      </developer>
    </developers>
