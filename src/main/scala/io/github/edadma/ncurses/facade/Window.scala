package io.github.edadma.ncurses.facade

import io.github.edadma.ncurses.extern.LibNcurses
import io.github.edadma.ncurses.extern.{LibNcurses => nc}

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

class Window private[facade] (private[facade] val win: LibNcurses.WINDOW) extends AnyVal {

  def printw(fmt: String, args: Any*): Int = Zone(implicit z => nc.vw_printw(win, toCString(fmt), varargs(args)))

  def move(y: Int, x: Int): Int = nc.wmove(win, y, x)

  def printw(y: Int, x: Int, fmt: String, args: Any*): Int = {
    move(y, x)
    printw(fmt, args: _*)
  }

  def getch: Int = nc.wgetch(win)

  def addstr(str: String): Int = Zone { implicit z =>
    nc.waddstr(win, toCString(str))
  }

  def addstr(str: String, n: Int): Int = Zone(implicit z => nc.waddnstr(win, toCString(str), n))

  def addstr(y: Int, x: Int, str: String): Int = Zone(implicit z => nc.mvwaddstr(win, y, x, toCString(str)))

  def addstr(y: Int, x: Int, str: String, n: Int): Int =
    Zone(implicit z => nc.mvwaddnstr(win, y, x, toCString(str), n))

  def addch(ch: Int): Int = nc.waddch(win, ch.toUInt)

  def addch(y: Int, x: Int, ch: Int): Int = nc.mvwaddch(win, y, x, ch.toUInt)

  def echochar(ch: Int): Int = nc.wechochar(win, ch.toUInt)

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

  def getstr(n: Int): (Int, String) = {
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

  def chgat(n: Int, attr: Int, pair: Short): Int = nc.wchgat(win, n, attr.toUInt, pair, null)

  def chgat(y: Int, x: Int, n: Int, attr: Int, pair: Short): Int = nc.mvwchgat(win, y, x, n, attr.toUInt, pair, null)

  def refresh: Int = nc.wrefresh(win)

  def box(verch: Int, horch: Int): Int = nc.box(win, verch.toUInt, horch.toUInt)

  def border(ls: Int, rs: Int, ts: Int, bs: Int, tl: Int, tr: Int, bl: Int, br: Int): Int =
    nc.wborder(win, ls.toUInt, rs.toUInt, ts.toUInt, bs.toUInt, tl.toUInt, tr.toUInt, bl.toUInt, br.toUInt)

  def mouse_trafo(y: Int, x: Int, to_screen: Boolean): (Boolean, Int, Int) = {
    val py = stackalloc[CInt]
    val px = stackalloc[CInt]

    !py = y
    !px = x
    (nc.wmouse_trafo(win, py, px, to_screen), !py, !px)
  }

  def wnoutrefresh: Int = nc.wnoutrefresh(win)

  def erase: Int = nc.werase(win)

  def scroll: Int = nc.scroll(win)

  def hline(ch: Int, n: Int): Int = nc.whline(win, ch.toUInt, n)

  def vline(ch: Int, n: Int): Int = nc.wvline(win, ch.toUInt, n)

  def hline(y: Int, x: Int, ch: Int, n: Int): Int = nc.mvwhline(win, y, x, ch.toUInt, n)

  def vline(y: Int, x: Int, ch: Int, n: Int): Int = nc.mvwvline(win, y, x, ch.toUInt, n)

  def wenclose(y: Int, x: Int): Boolean = nc.wenclose(win, y, x)

}
