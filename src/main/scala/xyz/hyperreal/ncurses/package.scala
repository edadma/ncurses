package xyz.hyperreal

import ncurses.{LibNcurses => nc}

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

package object ncurses {

  lazy val stdscr             = new Window(nc.stdscr)
  lazy val KEY_DOWN: Int      = nc.KEY_DOWN
  lazy val KEY_UP: Int        = nc.KEY_UP
  lazy val KEY_LEFT: Int      = nc.KEY_LEFT
  lazy val KEY_RIGHT: Int     = nc.KEY_RIGHT
  lazy val KEY_HOME: Int      = nc.KEY_HOME
  lazy val KEY_END: Int       = nc.KEY_END
  lazy val KEY_BACKSPACE: Int = nc.KEY_BACKSPACE
  lazy val KEY_DC: Int        = nc.KEY_DC
  lazy val KEY_PPAGE: Int     = nc.KEY_PPAGE
  lazy val KEY_NPAGE: Int     = nc.KEY_NPAGE
  lazy val KEY_IC: Int        = nc.KEY_IC
  lazy val KEY_STAB: Int      = nc.KEY_STAB
  lazy val OK: Int            = nc.OK
  lazy val ERR: Int           = nc.ERR
  lazy val A_NORMAL: Int      = nc.A_NORMAL
  lazy val A_STANDOUT: Int    = nc.A_STANDOUT
  lazy val A_UNDERLINE: Int   = nc.A_UNDERLINE
  lazy val A_REVERSE: Int     = nc.A_REVERSE
  lazy val A_BLINK: Int       = nc.A_BLINK
  lazy val A_DIM: Int         = nc.A_DIM
  lazy val A_BOLD: Int        = nc.A_BOLD
  lazy val A_PROTECT: Int     = nc.A_PROTECT
  lazy val A_INVIS: Int       = nc.A_INVIS
  lazy val A_ALTCHARSET: Int  = nc.A_ALTCHARSET
  lazy val A_CHARTEXT: Int    = nc.A_CHARTEXT
  lazy val ACS_VLINE: Int     = nc.ACS_VLINE.toInt

  private[ncurses] def varargs(args: Seq[Any])(implicit z: Zone) =
    toCVarArgList(
      args
        map {
          case s: String => CVarArg.materialize(toCString(s))
          case x         => x.asInstanceOf[CVarArg]
        })

  def initscr: Window = new Window(nc.initscr)

  def cbreak: Int = nc.cbreak

  def raw: Int = nc.raw

  def noecho: Int = nc.noecho

  def endwin: Int = nc.endwin

  def bkgdset(ch: Int): Unit = nc.bkgdset(ch.toUInt)

  def start_color: Int = nc.start_color

  def addstr(s: String): Int = Zone(implicit z => nc.addstr(toCString(s)))

  def addch(ch: Int): Int = nc.addch(ch.toUInt)

  def refresh: Int = nc.refresh

  def getch: Int = nc.getch

  def move(y: Int, x: Int): Int = nc.move(y, x)

  def scrl(n: Int): Int = nc.scrl(n)

  def mvaddstr(y: Int, x: Int, str: String): Int = Zone(implicit z => nc.mvaddstr(y, x, toCString(str)))

  def printw(fmt: String, args: Any*): Int = stdscr.printw(fmt, args: _*)

  def mvprintw(y: Int, x: Int, fmt: String, args: Any*): Int = {
    move(y, x)
    printw(fmt, args: _*)
  }

  def newwin(nlines: Int, ncols: Int, begin_y: Int, begin_x: Int): Window =
    new Window(nc.newwin(nlines, ncols, begin_y, begin_x))

  def keyname(c: Int): String = fromCString(nc.keyname(c))

  def update_panels(): Unit = nc.update_panels()

  def doupdate: Int = nc.doupdate

  def clrtoeol: Int = nc.clrtoeol

  def clrtobot: Int = nc.clrtobot

  def clear: Int = nc.clear

}
