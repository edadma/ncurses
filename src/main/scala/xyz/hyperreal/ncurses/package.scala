package xyz.hyperreal

import ncurses.{LibNcurses => nc}

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

package object ncurses {

  lazy val stdscr = new Window(nc.stdscr)

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

}
