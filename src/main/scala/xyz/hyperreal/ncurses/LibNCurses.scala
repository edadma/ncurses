package xyz.hyperreal.ncurses

import scala.scalanative.unsafe.{CBool, CInt, CString, CVarArgList, Ptr, extern, link, name}

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
  def wgetch(win: _win_st): CInt                                     = extern
  def vw_printw(win: _win_st, fmt: CString, args: CVarArgList): CInt = extern
  def wmove(win: _win_st, y: CInt, x: CInt): CInt                    = extern
  def waddnstr(win: _win_st, str: CString, n: CInt): CInt            = extern
  def keypad(win: _win_st, bf: CBool): CInt                          = extern
  def wclrtoeol(win: _win_st): CInt                                  = extern
  def wclrtobot(win: _win_st): CInt                                  = extern

  @name("ncurses_refresh")
  def refresh: CInt = extern
  @name("ncurses_getch")
  def getch: CInt = extern
  @name("ncurses_move")
  def move(y: CInt, x: CInt): CInt = extern
  @name("ncurses_addstr")
  def addstr(str: CString): CInt = extern
  @name("ncurses_KEY_DOWN")
  def KEY_DOWN: CInt = extern
  @name("ncurses_KEY_UP")
  def KEY_UP: CInt = extern
  @name("ncurses_KEY_LEFT")
  def KEY_LEFT: CInt = extern
  @name("ncurses_KEY_RIGHT")
  def KEY_RIGHT: CInt = extern
  @name("ncurses_KEY_HOME")
  def KEY_HOME: CInt = extern
  @name("ncurses_KEY_BACKSPACE")
  def KEY_BACKSPACE: CInt = extern
  @name("ncurses_KEY_DC")
  def KEY_DC: CInt = extern
  @name("ncurses_clrtoeol")
  def clrtoeol: CInt = extern
  @name("ncurses_clrtobot")
  def clrtobot: CInt = extern
  @name("ncurses_getmaxy")
  def getmaxy(win: _win_st): CInt = extern
  @name("ncurses_getmaxx")
  def getmaxx(win: _win_st): CInt = extern

}
