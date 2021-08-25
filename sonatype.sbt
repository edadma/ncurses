// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "io.github.edadma"

// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// Open-source license of your choice
licenses := Seq("ISC" -> url("https://opensource.org/licenses/ISC"))

// Where is the source code hosted: GitHub or GitLab?
import xerial.sbt.Sonatype._

sonatypeProjectHosting := Some(GitHubHosting("edadma", "ncurses", "edadma@gmail.com"))

// or if you want to set these fields manually
homepage := Some(url("https://edadma.github.io/ncurses/"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/edadma/ncurses"),
    "scm:git@github.com:edadma/ncurses.git"
  )
)

developers := List(
  Developer(id = "edadma",
            name = "Edward A Maxedon, Sr",
            email = "edadma@gmail.com",
            url = url("https://github.com/edadma"))
)
