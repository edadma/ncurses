package io.github.edadma.ncurses.extern

import scala.scalanative.unsafe._
@link("panel")
@link("ncurses")
@extern
object LibNcurses {

  type WINDOW  = Ptr[Byte]
  type PANEL   = Ptr[Byte]
  type chtype  = CUnsignedInt
  type attr_t  = chtype
  type mmask_t = CUnsignedInt
  type MEVENT  = CStruct5[CShort, CInt, CInt, CInt, CUnsignedInt]

  val stdscr: WINDOW = extern
  val LINES: CInt    = extern
  val COLS: CInt     = extern

  def initscr: WINDOW                                                                 = extern
  def cbreak: CInt                                                                    = extern
  def nocbreak: CInt                                                                  = extern
  def raw: CInt                                                                       = extern
  def noraw: CInt                                                                     = extern
  def echo: CInt                                                                      = extern
  def noecho: CInt                                                                    = extern
  def endwin: CInt                                                                    = extern
  def start_color: CInt                                                               = extern
  def wgetch(win: WINDOW): CInt                                                       = extern
  def vw_printw(win: WINDOW, fmt: CString, args: CVarArgList): CInt                   = extern
  def wmove(win: WINDOW, y: CInt, x: CInt): CInt                                      = extern
  def waddnstr(win: WINDOW, str: CString, n: CInt): CInt                              = extern
  def waddch(win: WINDOW, ch: chtype): CInt                                           = extern
  def mvaddch(x: CInt, n: CInt, ch: chtype): CInt                                     = extern
  def mvwaddch(win: WINDOW, x: CInt, n: CInt, ch: chtype): CInt                       = extern
  def echochar(ch: chtype): CInt                                                      = extern
  def wechochar(win: WINDOW, ch: chtype): CInt                                        = extern
  def keypad(win: WINDOW, bf: CBool): CInt                                            = extern
  def wclrtoeol(win: WINDOW): CInt                                                    = extern
  def wclrtobot(win: WINDOW): CInt                                                    = extern
  def newwin(nlines: CInt, ncols: CInt, begin_y: CInt, begin_x: CInt): WINDOW         = extern
  def delwin(win: WINDOW): CInt                                                       = extern
  def wclear(win: WINDOW): CInt                                                       = extern
  def wbkgdset(win: WINDOW, ch: chtype): Unit                                         = extern
  def wbkgd(win: WINDOW, ch: chtype): Unit                                            = extern
  def scrollok(win: WINDOW, bf: CBool): CInt                                          = extern
  def wscrl(win: WINDOW, n: CInt): CInt                                               = extern
  def keyname(c: CInt): CString                                                       = extern
  def nodelay(win: WINDOW, bf: CBool): Unit                                           = extern
  def wresize(win: WINDOW, lines: CInt, columns: CInt): Unit                          = extern
  def new_panel(win: WINDOW): PANEL                                                   = extern
  def panel_above(panel: PANEL): PANEL                                                = extern
  def panel_below(panel: PANEL): PANEL                                                = extern
  def update_panels(): Unit                                                           = extern
  def doupdate: CInt                                                                  = extern
  def redrawwin(win: WINDOW): CInt                                                    = extern
  def wredrawln(win: WINDOW, beg_line: CInt, num_lines: CInt): CInt                   = extern
  def init_pair(pair: CShort, f: CShort, b: CShort): CInt                             = extern
  def init_color(color: CShort, r: CShort, g: CShort, b: CShort): CInt                = extern
  def curs_set(visibility: CInt): CInt                                                = extern
  def wgetnstr(win: WINDOW, str: CString, n: CInt): CInt                              = extern
  def wchgat(win: WINDOW, n: CInt, attr: attr_t, pair: CShort, opts: Ptr[Byte]): CInt = extern
  def wrefresh(win: WINDOW): CInt                                                     = extern
  def wborder(win: WINDOW,
              ls: chtype,
              rs: chtype,
              ts: chtype,
              bs: chtype,
              tl: chtype,
              tr: chtype,
              bl: chtype,
              br: chtype): CInt                                                      = extern
  def mousemask(newmask: mmask_t, oldmask: Ptr[mmask_t]): mmask_t                    = extern
  def mouseinterval(interval: CInt): CInt                                            = extern
  def getmouse(event: Ptr[MEVENT]): CInt                                             = extern
  def has_colors: CBool                                                              = extern
  def mouse_trafo(y: Ptr[CInt], x: Ptr[CInt], to_screen: CBool): CBool               = extern
  def wmouse_trafo(win: WINDOW, y: Ptr[CInt], x: Ptr[CInt], to_screen: CBool): CBool = extern
  def def_prog_mode: CInt                                                            = extern
  def reset_prog_mode: CInt                                                          = extern
  def show_panel(pan: PANEL): CInt                                                   = extern
  def hide_panel(pan: PANEL): CInt                                                   = extern
  def top_panel(pan: PANEL): CInt                                                    = extern
  def bottom_panel(pan: PANEL): CInt                                                 = extern
  def del_panel(pan: PANEL): CInt                                                    = extern
  def wnoutrefresh(win: WINDOW): CInt                                                = extern
  def werase(win: WINDOW): CInt                                                      = extern
  def beep: CInt                                                                     = extern
  def flash: CInt                                                                    = extern
  def whline(win: WINDOW, ch: chtype, n: CInt): CInt                                 = extern
  def wvline(win: WINDOW, ch: chtype, n: CInt): CInt                                 = extern
  def wenclose(win: WINDOW, y: CInt, x: CInt): CBool                                 = extern
  def has_mouse: CBool                                                               = extern
  def mvwin(win: WINDOW, y: CInt, x: CInt): CInt                                     = extern
  def use_default_colors: CInt                                                       = extern
  def assume_default_colors(fg: CInt, bg: CInt): CInt                                = extern
  def panel_window(pan: PANEL): WINDOW                                               = extern
  def replace_panel(pan: PANEL, win: WINDOW): CInt                                   = extern
  def move_panel(pan: PANEL, starty: CInt, startx: CInt): CInt                       = extern
  def panel_hidden(pan: PANEL): CBool                                                = extern
  def set_panel_userptr(pan: PANEL, ptr: Ptr[Byte]): CInt                            = extern
  def panel_userptr(pan: PANEL): Ptr[Byte]                                           = extern
  def waddchnstr(win: WINDOW, chstr: Ptr[chtype], n: CInt): CInt                     = extern

  @name("ncurses_refresh")
  def refresh: CInt = extern
  @name("ncurses_getch")
  def getch: CInt = extern
  @name("ncurses_erase")
  def erase: CInt = extern
  @name("ncurses_scrl")
  def scrl(n: CInt): CInt = extern
  @name("ncurses_move")
  def move(y: CInt, x: CInt): CInt = extern
  @name("ncurses_addstr")
  def addstr(str: CString): CInt = extern
  @name("ncurses_addnstr")
  def addnstr(str: CString, n: CInt): CInt = extern
  @name("ncurses_mvaddstr")
  def mvaddstr(y: CInt, x: CInt, str: CString): CInt = extern
  @name("ncurses_waddstr")
  def waddstr(win: WINDOW, str: CString): CInt = extern
  @name("ncurses_mvwaddstr")
  def mvwaddstr(win: WINDOW, y: CInt, x: CInt, str: CString): CInt = extern
  @name("ncurses_mvaddnstr")
  def mvaddnstr(y: CInt, x: CInt, str: CString, n: CInt): CInt = extern
  @name("ncurses_mvwaddnstr")
  def mvwaddnstr(win: WINDOW, y: CInt, x: CInt, str: CString, n: CInt): CInt = extern
  @name("ncurses_addch")
  def addch(ch: chtype): CInt = extern
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
  @name("ncurses_KEY_MOUSE")
  def KEY_MOUSE: CInt = extern
  @name("ncurses_KEY_F1")
  def KEY_F1: CInt = extern
  @name("ncurses_KEY_F2")
  def KEY_F2: CInt = extern
  @name("ncurses_KEY_F3")
  def KEY_F3: CInt = extern
  @name("ncurses_KEY_F4")
  def KEY_F4: CInt = extern
  @name("ncurses_KEY_F5")
  def KEY_F5: CInt = extern
  @name("ncurses_KEY_F6")
  def KEY_F6: CInt = extern
  @name("ncurses_KEY_F7")
  def KEY_F7: CInt = extern
  @name("ncurses_KEY_F8")
  def KEY_F8: CInt = extern
  @name("ncurses_KEY_F9")
  def KEY_F9: CInt = extern
  @name("ncurses_KEY_F10")
  def KEY_F10: CInt = extern
  @name("ncurses_KEY_F11")
  def KEY_F11: CInt = extern
  @name("ncurses_KEY_F12")
  def KEY_F12: CInt = extern
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
  @name("ncurses_bkgdset")
  def bkgdset(ch: chtype): Unit = extern
  @name("ncurses_bkgd")
  def bkgd(ch: chtype): Unit = extern
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
  @name("ncurses_ACS_ULCORNER")
  def ACS_ULCORNER: CInt = extern
  @name("ncurses_ACS_LLCORNER")
  def ACS_LLCORNER: CInt = extern
  @name("ncurses_ACS_URCORNER")
  def ACS_URCORNER: CInt = extern
  @name("ncurses_ACS_LRCORNER")
  def ACS_LRCORNER: CInt = extern
  @name("ncurses_ACS_LTEE")
  def ACS_LTEE: CInt = extern
  @name("ncurses_ACS_RTEE")
  def ACS_RTEE: CInt = extern
  @name("ncurses_ACS_BTEE")
  def ACS_BTEE: CInt = extern
  @name("ncurses_ACS_TTEE")
  def ACS_TTEE: CInt = extern
  @name("ncurses_ACS_HLINE")
  def ACS_HLINE: CInt = extern
  @name("ncurses_ACS_VLINE")
  def ACS_VLINE: CInt = extern
  @name("ncurses_ACS_PLUS")
  def ACS_PLUS: CInt = extern
  @name("ncurses_ACS_S1")
  def ACS_S1: CInt = extern
  @name("ncurses_ACS_S9")
  def ACS_S9: CInt = extern
  @name("ncurses_ACS_DIAMOND")
  def ACS_DIAMOND: CInt = extern
  @name("ncurses_ACS_CKBOARD")
  def ACS_CKBOARD: CInt = extern
  @name("ncurses_ACS_DEGREE")
  def ACS_DEGREE: CInt = extern
  @name("ncurses_ACS_PLMINUS")
  def ACS_PLMINUS: CInt = extern
  @name("ncurses_ACS_BULLET")
  def ACS_BULLET: CInt = extern
  @name("ncurses_ACS_LARROW")
  def ACS_LARROW: CInt = extern
  @name("ncurses_ACS_RARROW")
  def ACS_RARROW: CInt = extern
  @name("ncurses_ACS_DARROW")
  def ACS_DARROW: CInt = extern
  @name("ncurses_ACS_UARROW")
  def ACS_UARROW: CInt = extern
  @name("ncurses_ACS_BOARD")
  def ACS_BOARD: CInt = extern
  @name("ncurses_ACS_LANTERN")
  def ACS_LANTERN: CInt = extern
  @name("ncurses_ACS_BLOCK")
  def ACS_BLOCK: CInt = extern
  @name("ncurses_ACS_S3")
  def ACS_S3: CInt = extern
  @name("ncurses_ACS_S7")
  def ACS_S7: CInt = extern
  @name("ncurses_ACS_LEQUAL")
  def ACS_LEQUAL: CInt = extern
  @name("ncurses_ACS_GEQUAL")
  def ACS_GEQUAL: CInt = extern
  @name("ncurses_ACS_PI")
  def ACS_PI: CInt = extern
  @name("ncurses_ACS_NEQUAL")
  def ACS_NEQUAL: CInt = extern
  @name("ncurses_ACS_STERLING")
  def ACS_STERLING: CInt = extern
  @name("ncurses_ACS_BSSB")
  def ACS_BSSB: CInt = extern
  @name("ncurses_ACS_SSBB")
  def ACS_SSBB: CInt = extern
  @name("ncurses_ACS_BBSS")
  def ACS_BBSS: CInt = extern
  @name("ncurses_ACS_SBBS")
  def ACS_SBBS: CInt = extern
  @name("ncurses_ACS_SBSS")
  def ACS_SBSS: CInt = extern
  @name("ncurses_ACS_SSSB")
  def ACS_SSSB: CInt = extern
  @name("ncurses_ACS_SSBS")
  def ACS_SSBS: CInt = extern
  @name("ncurses_ACS_BSSS")
  def ACS_BSSS: CInt = extern
  @name("ncurses_ACS_BSBS")
  def ACS_BSBS: CInt = extern
  @name("ncurses_ACS_SBSB")
  def ACS_SBSB: CInt = extern
  @name("ncurses_ACS_SSSS")
  def ACS_SSSS: CInt = extern
  @name("ncurses_COLOR_PAIR")
  def COLOR_PAIR(c: CInt): CInt = extern
  @name("ncurses_getmaxyx")
  def getmaxyx(win: WINDOW, y: Ptr[CInt], x: Ptr[CInt]): Unit = extern
  @name("ncurses_getyx")
  def getyx(win: WINDOW, y: Ptr[CInt], x: Ptr[CInt]): Unit = extern
  @name("ncurses_getcury")
  def getcury(win: WINDOW): CInt = extern
  @name("ncurses_getcurx")
  def getcurx(win: WINDOW): CInt = extern
  @name("ncurses_scroll")
  def scroll(win: WINDOW): CInt = extern
  @name("ncurses_mvwchgat")
  def mvwchgat(win: WINDOW, y: CInt, x: CInt, n: CInt, attr: attr_t, pair: CShort, opts: Ptr[Byte]): CInt = extern
  @name("ncurses_chgat")
  def chgat(n: CInt, attr: attr_t, pair: CShort, opts: Ptr[Byte]): CInt = extern
  @name("ncurses_mvchgat")
  def mvchgat(y: CInt, x: CInt, n: CInt, attr: attr_t, pair: CShort, opts: Ptr[Byte]): CInt = extern
  @name("ncurses_box")
  def box(win: WINDOW, verch: chtype, horch: chtype): CInt = extern
  @name("ncurses_mvhline")
  def mvhline(y: CInt, x: CInt, ch: chtype, n: CInt): CInt = extern
  @name("ncurses_mvvline")
  def mvvline(y: CInt, x: CInt, ch: chtype, n: CInt): CInt = extern
  @name("ncurses_mvwhline")
  def mvwhline(win: WINDOW, y: CInt, x: CInt, ch: chtype, n: CInt): CInt = extern
  @name("ncurses_mvwvline")
  def mvwvline(win: WINDOW, y: CInt, x: CInt, ch: chtype, n: CInt): CInt = extern
  @name("ncurses_ALL_MOUSE_EVENTS")
  def ALL_MOUSE_EVENTS: mmask_t = extern
  @name("ncurses_BUTTON1_RELEASED")
  def BUTTON1_RELEASED: mmask_t = extern
  @name("ncurses_BUTTON1_PRESSED")
  def BUTTON1_PRESSED: mmask_t = extern
  @name("ncurses_BUTTON1_CLICKED")
  def BUTTON1_CLICKED: mmask_t = extern
  @name("ncurses_BUTTON1_DOUBLE_CLICKED")
  def BUTTON1_DOUBLE_CLICKED: mmask_t = extern
  @name("ncurses_BUTTON1_TRIPLE_CLICKED")
  def BUTTON1_TRIPLE_CLICKED: mmask_t = extern
  @name("ncurses_BUTTON2_RELEASED")
  def BUTTON2_RELEASED: mmask_t = extern
  @name("ncurses_BUTTON2_PRESSED")
  def BUTTON2_PRESSED: mmask_t = extern
  @name("ncurses_BUTTON2_CLICKED")
  def BUTTON2_CLICKED: mmask_t = extern
  @name("ncurses_BUTTON2_DOUBLE_CLICKED")
  def BUTTON2_DOUBLE_CLICKED: mmask_t = extern
  @name("ncurses_BUTTON2_TRIPLE_CLICKED")
  def BUTTON2_TRIPLE_CLICKED: mmask_t = extern
  @name("ncurses_BUTTON_CTRL")
  def BUTTON_CTRL: mmask_t = extern
  @name("ncurses_BUTTON_SHIFT")
  def BUTTON_SHIFT: mmask_t = extern
  @name("ncurses_BUTTON_ALT")
  def BUTTON_ALT: mmask_t = extern
  @name("ncurses_REPORT_MOUSE_POSITION")
  def REPORT_MOUSE_POSITION: mmask_t = extern
  @name("ncurses_COLOR_BLACK")
  def COLOR_BLACK: CInt = extern
  @name("ncurses_COLOR_RED")
  def COLOR_RED: CInt = extern
  @name("ncurses_COLOR_GREEN")
  def COLOR_GREEN: CInt = extern
  @name("ncurses_COLOR_YELLOW")
  def COLOR_YELLOW: CInt = extern
  @name("ncurses_COLOR_BLUE")
  def COLOR_BLUE: CInt = extern
  @name("ncurses_COLOR_MAGENTA")
  def COLOR_MAGENTA: CInt = extern
  @name("ncurses_COLOR_CYAN")
  def COLOR_CYAN: CInt = extern
  @name("ncurses_COLOR_WHITE")
  def COLOR_WHITE: CInt = extern
  @name("ncurses_border")
  def border(ls: chtype, rs: chtype, ts: chtype, bs: chtype, tl: chtype, tr: chtype, bl: chtype, br: chtype): CInt =
    extern
  @name("ncurses_addchstr")
  def addchstr(chstr: Ptr[chtype]): CInt = extern
  @name("ncurses_addchnstr")
  def addchnstr(chstr: Ptr[chtype], n: CInt): CInt = extern
  @name("ncurses_waddchstr")
  def waddchstr(win: WINDOW, chstr: Ptr[chtype]): CInt = extern
  @name("ncurses_mvaddchstr")
  def mvaddchstr(y: CInt, x: CInt, chstr: Ptr[chtype]): CInt = extern
  @name("ncurses_mvaddchnstr")
  def mvaddchnstr(y: CInt, x: CInt, chstr: Ptr[chtype], n: CInt): CInt = extern
  @name("ncurses_mvwaddchstr")
  def mvwaddchstr(win: WINDOW, y: CInt, x: CInt, chstr: Ptr[chtype]): CInt = extern
  @name("ncurses_mvwaddchnstr")
  def mvwaddchnstr(win: WINDOW, y: CInt, x: CInt, chstr: Ptr[chtype], n: CInt): CInt = extern

}
// todo: https://invisible-island.net/ncurses/man/curs_addchstr.3x.html
// todo: wide characters: ncursesw project
