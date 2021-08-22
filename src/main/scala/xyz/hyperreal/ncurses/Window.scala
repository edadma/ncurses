package xyz.hyperreal.ncurses

import xyz.hyperreal.ncurses.{LibNcurses => nc}
import nc.{PANEL, WINDOW}

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

class Window(val win: WINDOW) extends AnyVal {

  def printw(fmt: String, args: Any*): CInt = Zone(implicit z => nc.vw_printw(win, toCString(fmt), varargs(args)))

  def move(y: Int, x: Int): Int = nc.wmove(win, y, x)

  def mvprintw(y: Int, x: Int, fmt: String, args: Any*): CInt = {
    move(y, x)
    printw(fmt, args: _*)
  }

  def getch(): Int = nc.wgetch(win)

  def addstr(str: String): Int = Zone(implicit z => nc.waddstr(win, toCString(str)))

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

  def new_panel: Panel = new Panel(nc.new_panel(win))

  def getmaxy: Int = nc.getmaxy(win)

  def getmaxx: Int = nc.getmaxx(win)

  def attron(attr: Int): Int = nc.wattron(win, attr)

  def attroff(attr: Int): Int = nc.wattroff(win, attr)

}
