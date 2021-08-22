ncurses
=======

*ncurses* provides bindings for the GNU Ncurses library.  This package is a work in progress as there are hundreds of functions in the Ncurses library.  Nonetheless, this package is very usable as it.  `libncurses-dev` needs to be installed.

Example
-------

```scala
import xyz.hyperreal.ncurses._

object Main extends App {

  try {
    initscr
    raw
    noecho
    addstr("Scala Native is awesome!")
    getch
  } catch {
    case e: Exception =>
      endwin
      e.printStackTrace()
  }

  endwin

}
```
