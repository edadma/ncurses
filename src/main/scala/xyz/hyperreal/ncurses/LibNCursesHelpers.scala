package xyz.hyperreal.ncurses

import xyz.hyperreal.ncurses.{LibNCurses => nc}

import scala.scalanative.unsafe.{CInt, CVarArg, Zone, toCString, toCVarArgList}

object LibNCursesHelpers {

  def wprintw(win: nc._win_st, fmt: String, args: CVarArg*): CInt = Zone { implicit z =>
    nc.vw_printw(win, toCString(fmt), toCVarArgList(args.toSeq))
  }

  def printw(fmt: String, args: CVarArg*): CInt = wprintw(nc.stdscr, fmt, args)

}
