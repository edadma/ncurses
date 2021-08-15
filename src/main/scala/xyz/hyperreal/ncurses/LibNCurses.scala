package xyz.hyperreal.ncurses

import scala.scalanative.unsafe.{CInt, CString, CVarArgList, Ptr, extern, link, name}

@link("ncurses")
@extern
object LibNCurses {

  type _win_st = Ptr[Byte]

  val stdscr: _win_st = extern

  def initscr: Ptr[_win_st]                                          = extern
  def endwin: CInt                                                   = extern
  def vw_printw(win: _win_st, fmt: CString, args: CVarArgList): CInt = extern

  @name("ncurses_define_refresh")
  def refresh: CInt = extern
  @name("ncurses_define_getch")
  def getch: CInt = extern

}
