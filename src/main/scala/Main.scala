import xyz.hyperreal.ncurses._
import xyz.hyperreal.ncurses.{LibNcurses => nc}

import scala.scalanative.unsigned.UnsignedRichInt

object Main extends App {

  try {
    initscr

    val win   = newwin(10, 30, 0, 0)
    val panel = new_panel(win)

    raw
    noecho

    nc.bkgdset((' ' | A_REVERSE | A_DIM).toUInt)
    clrtoeol

    win.mvaddstr(3, 0, "asdf")
    win.addch('\n')
    win.addstr(keyname(win.getch))
    win.getch
    win.delwin
  } catch {
    case e: Exception =>
      endwin
      e.printStackTrace()
  }

  endwin

}
