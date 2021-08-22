package xyz.hyperreal.ncurses

import xyz.hyperreal.ncurses.{LibNcurses => nc}
import nc.WINDOW

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

class Window(val win: WINDOW) extends AnyVal {

  def printw(fmt: String, args: Any*): CInt = Zone(implicit z => nc.vw_printw(win, toCString(fmt), varargs(args)))

  def move(y: Int, x: Int): Int = nc.wmove(win, y, x)

  def mvprintw(y: Int, x: Int, fmt: String, args: Any*): CInt = {
    move(y, x)
    printw(fmt, args: _*)
  }

  def mvwprintw(y: Int, x: Int, fmt: String, args: Any*): CInt = {
    move(y, x)
    printw(fmt, args: _*)
  }

  def getch(): Int = nc.wgetch(win)

  def addnstr(str: String, n: Int): Int = Zone(implicit z => nc.waddnstr(win, toCString(str), n))

  def addch(ch: Int): Int = nc.waddch(win, ch.toUInt)

  def keypad(bf: Boolean): Int = nc.keypad(win, bf)

  def clrtoeol: Int = nc.wclrtoeol(win)

  def clrtobot: Int = nc.wclrtobot(win)

}
