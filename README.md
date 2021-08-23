ncurses
=======

*ncurses* provides bindings for the GNU Ncurses library.  This package is a work in progress as there are hundreds of functions in the Ncurses library.  Nonetheless, this package is quite usable as is.  `libncurses-dev` needs to be installed.

Obligatory "Hello World" example
--------------------------------

```scala
import xyz.hyperreal.ncurses._

object Main extends App {

  try {
    initscr
    raw

    val prompt       = "Type something: "
    val (rows, cols) = stdscr.getmaxyx

    mvaddstr(rows / 2, (cols - prompt.length) / 2, prompt)

    val (_, s) = getnstr(20)

    noecho
    curs_set(0)
    mvaddstr(rows - 1, 0, s"You entered: $s")
    getch
  } catch {
    case e: Exception =>
      endwin
      e.printStackTrace()
      sys.exit(1)
  }

  endwin

}
```
