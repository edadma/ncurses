ncurses
=======

*ncurses* provides bindings for the GNU Ncurses library.  This package is not at all complete yet.

Example
-------

```scala
import xyz.hyperreal.ncurses.{LibNCurses => nc, LibNCursesHelpers => nch}

object Main extends App {

  nc.initscr
  nch.printw("Scala Native is awesome!")
  nc.getch
  nc.endwin

}
```
