package xyz.hyperreal.ncurses

import scala.scalanative.unsafe.{CBool, CInt, CString, CVarArgList, Ptr, extern, link, name}

@link("ncurses")
@extern
object LibNCurses {

  type WINDOW = Ptr[Byte]
  type PANEL  = Ptr[Byte]

  val stdscr: WINDOW = extern

  def initscr: Ptr[WINDOW]                                                    = extern
  def cbreak: CInt                                                            = extern
  def raw: CInt                                                               = extern
  def noecho: CInt                                                            = extern
  def endwin: CInt                                                            = extern
  def start_color: CInt                                                       = extern
  def wgetch(win: WINDOW): CInt                                               = extern
  def vw_printw(win: WINDOW, fmt: CString, args: CVarArgList): CInt           = extern
  def wmove(win: WINDOW, y: CInt, x: CInt): CInt                              = extern
  def waddnstr(win: WINDOW, str: CString, n: CInt): CInt                      = extern
  def keypad(win: WINDOW, bf: CBool): CInt                                    = extern
  def wclrtoeol(win: WINDOW): CInt                                            = extern
  def wclrtobot(win: WINDOW): CInt                                            = extern
  def newwin(nlines: CInt, ncols: CInt, begin_y: CInt, begin_x: CInt): WINDOW = extern
  def delwin(win: WINDOW): CInt                                               = extern
  def wclear(win: WINDOW): CInt                                               = extern
  def wbkgdset(win: WINDOW, chtype: CInt): Unit                               = extern
  def scrollok(win: WINDOW, bf: CBool): Unit                                  = extern
  def wscrl(win: WINDOW, n: CInt): Unit                                       = extern
  def keyname(c: CInt): CString                                               = extern
  def nodelay(win: WINDOW, bf: CBool): Unit                                   = extern
  def wresize(win: WINDOW, lines: CInt, columns: CInt): Unit                  = extern
  def new_panel(win: WINDOW): PANEL                                           = extern
  def panel_above(win: PANEL): PANEL                                          = extern
  def update_panels(): Unit                                                   = extern
  def doupdate: CInt                                                          = extern
  def panel_above(win: PANEL): PANEL                                          = extern

  @name("ncurses_refresh")
  def refresh: CInt = extern
  @name("ncurses_getch")
  def getch: CInt = extern
  @name("ncurses_move")
  def move(y: CInt, x: CInt): CInt = extern
  @name("ncurses_addstr")
  def addstr(str: CString): CInt = extern
  @name("ncurses_mvaddstr")
  def mvaddstr(y: CInt, x: CInt, str: CString): CInt = extern
  @name("ncurses_waddstr")
  def waddstr(win: WINDOW, str: CString): CInt = extern
  @name("ncurses_mvwaddstr")
  def mvwaddstr(win: WINDOW, y: CInt, x: CInt, str: CString): CInt = extern
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
  @name("ncurses_KEY_END")
  def KEY_END: CInt = extern
  @name("ncurses_KEY_BACKSPACE")
  def KEY_BACKSPACE: CInt = extern
  @name("ncurses_KEY_DC")
  def KEY_DC: CInt = extern
  @name("ncurses_KEY_PPAGE")
  def KEY_PPAGE: CInt = extern
  @name("ncurses_KEY_NPAGE")
  def KEY_NPAGE: CInt = extern
  @name("ncurses_KEY_IC")
  def KEY_IC: CInt = extern
  @name("ncurses_KEY_STAB")
  def KEY_STAB: CInt = extern
  @name("ncurses_clrtoeol")
  def clrtoeol: CInt = extern
  @name("ncurses_clrtobot")
  def clrtobot: CInt = extern
  @name("ncurses_getmaxy")
  def getmaxy(win: WINDOW): CInt = extern
  @name("ncurses_getmaxx")
  def getmaxx(win: WINDOW): CInt = extern
  @name("ncurses_clear")
  def clear: CInt = extern
  @name("ncurses_OK")
  def OK: CInt = extern
  @name("ncurses_ERR")
  def ERR: CInt = extern
  @name("ncurses_wattron")
  def wattron(win: WINDOW, attr: CInt): CInt = extern
  @name("ncurses_wattroff")
  def wattroff(win: WINDOW, attr: CInt): CInt = extern
  @name("ncurses_attron")
  def attron(attr: CInt): CInt = extern
  @name("ncurses_attroff")
  def attroff(attr: CInt): CInt = extern
  @name("ncurses_A_NORMAL")
  def A_NORMAL: CInt = extern
  @name("ncurses_A_STANDOUT")
  def A_STANDOUT: CInt = extern
  @name("ncurses_A_UNDERLINE")
  def A_UNDERLINE: CInt = extern
  @name("ncurses_A_REVERSE")
  def A_REVERSE: CInt = extern
  @name("ncurses_A_BLINK")
  def A_BLINK: CInt = extern
  @name("ncurses_A_DIM")
  def A_DIM: CInt = extern
  @name("ncurses_A_BOLD")
  def A_BOLD: CInt = extern
  @name("ncurses_A_PROTECT")
  def A_PROTECT: CInt = extern
  @name("ncurses_A_INVIS")
  def A_INVIS: CInt = extern
  @name("ncurses_A_ALTCHARSET")
  def A_ALTCHARSET: CInt = extern
  @name("ncurses_A_CHARTEXT")
  def A_CHARTEXT: CInt = extern

}
