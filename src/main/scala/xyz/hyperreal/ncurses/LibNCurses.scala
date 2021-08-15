package xyz.hyperreal.ncurses

import scala.scalanative.unsafe.{CInt, CString, CVarArgList, Ptr, extern, link, name}
@link("ncurses")
@extern
object LibNCurses {

  type _win_st = Ptr[Byte]

  val stdscr: _win_st = extern

  def initscr: Ptr[_win_st]                                          = extern
  def cbreak: CInt                                                   = extern
  def raw: CInt                                                      = extern
  def noecho: CInt                                                   = extern
  def endwin: CInt                                                   = extern
  def vw_printw(win: _win_st, fmt: CString, args: CVarArgList): CInt = extern
  def wmove(win: _win_st, y: CInt, x: CInt): CInt                    = extern
  def waddnstr(win: _win_st, str: CString, n: CInt): CInt            = extern

  @name("ncurses_refresh")
  def refresh: CInt = extern
  @name("ncurses_getch")
  def getch: CInt = extern
  @name("ncurses_move")
  def move(y: CInt, x: CInt): CInt = extern
  @name("ncurses_addstr")
  def addstr(str: CString): CInt = extern

}
