ncurses
=======

![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/edadma/ncurses?include_prereleases) ![GitHub (Pre-)Release Date](https://img.shields.io/github/release-date-pre/edadma/ncurses) ![GitHub last commit](https://img.shields.io/github/last-commit/edadma/ncurses) ![GitHub](https://img.shields.io/github/license/edadma/ncurses)

*ncurses* provides Scala Native bindings for the [GNU Ncurses C library](https://invisible-island.net/ncurses/announce.html).

Documentation
-------------

See https://edadma.github.io/ncurses/.

Usage
-----

To use this library, `libncurses-dev` needs to be installed:

```shell
sudo apt install libncurses-dev
```

Include the following in your `project/plugins.sbt`:

```sbt
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.3")
```

Include the following in your `build.sbt`:

```sbt
resolvers += Resolver.githubPackages("edadma")

libraryDependencies += "io.github.edadma" %%% "ncurses" % "0.2.6"
```

Use the following `import` in your code:

```scala
import io.github.edadma.ncurses._
```

The obligatory "Hello World" example
------------------------------------

```scala
import io.github.edadma.ncurses._

object Main extends App {
  initscr                     /* Start curses mode */
  printw("Hello World !!!");  /* Print Hello World */
  refresh                     /* Print it on to the real screen */
  getch                       /* Wait for user input */
  endwin                      /* End curses mode */
}
```

License
-------

[ISC](https://github.com/edadma/ncurses/blob/main/LICENSE)