package xyz.hyperreal.ncurses

import xyz.hyperreal.ncurses.{LibNCurses => nc}

import scala.scalanative.unsafe.{CInt, CVarArg, Zone, toCString, toCVarArgList}

object LibNCursesHelpers {

  def wprintw(win: nc.WINDOW, fmt: String, args: CVarArg*): CInt = Zone { implicit z =>
    nc.vw_printw(win, toCString(fmt), toCVarArgList(args.toSeq))
  }

  def mvprintw(y: Int, x: Int, fmt: String, args: CVarArg*): CInt = {
    nc.move(y, x)
    printw(fmt, args: _*)
  }

  def mvwprintw(win: nc.WINDOW, y: Int, x: Int, fmt: String, args: CVarArg*): CInt = {
    nc.wmove(win, y, x)
    wprintw(win, fmt, args: _*)
  }

  def printw(fmt: String, args: CVarArg*): CInt = wprintw(nc.stdscr, fmt, args: _*)

}
