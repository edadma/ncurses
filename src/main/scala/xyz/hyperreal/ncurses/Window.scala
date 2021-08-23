package xyz.hyperreal.ncurses

import xyz.hyperreal.ncurses.{LibNcurses => nc}
import nc.WINDOW

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

class Window private[ncurses] (private[ncurses] val win: WINDOW) extends AnyVal {

  def printw(fmt: String, args: Any*): CInt = Zone(implicit z => nc.vw_printw(win, toCString(fmt), varargs(args)))

  def move(y: Int, x: Int): Int = nc.wmove(win, y, x)

  def mvprintw(y: Int, x: Int, fmt: String, args: Any*): CInt = {
    move(y, x)
    printw(fmt, args: _*)
  }

  def getch: Int = nc.wgetch(win)

  def addstr(str: String): Int = Zone { implicit z =>
    nc.waddstr(win, toCString(str))
  }

  def addnstr(str: String, n: Int): Int = Zone(implicit z => nc.addnstr(toCString(str), n))

  def mvaddstr(y: Int, x: Int, str: String): Int = Zone(implicit z => nc.mvwaddstr(win, y, x, toCString(str)))

  def addch(ch: Int): Int = nc.waddch(win, ch.toUInt)

  def keypad(bf: Boolean): Int = nc.keypad(win, bf)

  def clrtoeol: Int = nc.wclrtoeol(win)

  def clrtobot: Int = nc.wclrtobot(win)

  def delwin: Int = nc.delwin(win)

  def clear: Int = nc.wclear(win)

  def bkgdset(ch: Int): Unit = nc.wbkgdset(win, ch.toUInt)

  def scrollok(bf: Boolean): Unit = nc.scrollok(win, bf)

  def scrl(n: Int): Int = nc.wscrl(win, n)

  def nodelay(bf: Boolean): Unit = nc.nodelay(win, bf)

  def wresize(lines: Int, columns: Int): Unit = nc.wresize(win, lines, columns)

  def getmaxy: Int = nc.getmaxy(win)

  def getmaxx: Int = nc.getmaxx(win)

  def attron(attr: Int): Int = nc.wattron(win, attr)

  def attroff(attr: Int): Int = nc.wattroff(win, attr)

  def redrawwin: Int = nc.redrawwin(win)

  def wredrawln(beg_line: Int, num_lines: Int): Int = nc.wredrawln(win, beg_line, num_lines)

  def init_pair(pair: Short, f: Short, b: Short): Int = nc.init_pair(pair, f, b)

  def init_color(color: Short, r: Short, g: Short, b: Short): Int = nc.init_color(color, r, g, b)

  def getnstr(n: Int): (Int, String) = {
    require(n > 0, s"getnstr: n should be positive: n = $n")

    val buf = stackalloc[CChar]((n + 1).toUInt)

    (nc.wgetnstr(win, buf, n), fromCString(buf))
  }

  def getmaxyx: (Int, Int) = {
    val y = stackalloc[CInt]
    val x = stackalloc[CInt]

    nc.getmaxyx(win, y, x)
    (!y, !x)
  }

  def getyx: (Int, Int) = {
    val y = stackalloc[CInt]
    val x = stackalloc[CInt]

    nc.getyx(win, y, x)
    (!y, !x)
  }

  def getcury: Int = nc.getcury(win)

  def getcurx: Int = nc.getcurx(win)

}
