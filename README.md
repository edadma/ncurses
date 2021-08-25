ncurses
=======

*ncurses* provides Scala Native bindings for the [GNU Ncurses C library](https://invisible-island.net/ncurses/man/ncurses.3x.html).

Documentation
-------------

See https://edadma.github.io/ncurses/.

Usage
-----

To use this library, `libncurses-dev` needs to be installed:

```shell
sudo apt install libncurses-dev
```

Include the following in your `build.sbt`:

```scala
libraryDependencies += "io.github.edadma" %%% "ncurses" % "0.2.1"
```

Use the following `import`:

```scala
import io.github.edadma.ncurses.facade._
```

The obligatory "Hello World" example
------------------------------------

```scala
import io.github.edadma.ncurses.facade._

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