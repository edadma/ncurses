package xyz.hyperreal.ncurses

import scala.scalanative.unsafe.{CBool, CInt, CString, CVarArgList, Ptr, extern, link, name}

@link("ncurses")
@extern
object LibNCurses {

  type WINDOW = Ptr[Byte]

  val stdscr: WINDOW = extern

  def initscr: Ptr[WINDOW]                                                    = extern
  def cbreak: CInt                                                            = extern
  def raw: CInt                                                               = extern
  def noecho: CInt                                                            = extern
  def endwin: CInt                                                            = extern
  def wgetch(win: WINDOW): CInt                                               = extern
  def vw_printw(win: WINDOW, fmt: CString, args: CVarArgList): CInt           = extern
  def wmove(win: WINDOW, y: CInt, x: CInt): CInt                              = extern
  def waddnstr(win: WINDOW, str: CString, n: CInt): CInt                      = extern
  def keypad(win: WINDOW, bf: CBool): CInt                                    = extern
  def wclrtoeol(win: WINDOW): CInt                                            = extern
  def wclrtobot(win: WINDOW): CInt                                            = extern
  def newwin(nlines: CInt, ncols: CInt, begin_y: CInt, begin_x: CInt): WINDOW = extern
  def delwin(win: WINDOW): CInt                                               = extern

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
  def getmaxy(win: WINDOW): CInt = extern
  @name("ncurses_getmaxx")
  def getmaxx(win: WINDOW): CInt = extern

}
