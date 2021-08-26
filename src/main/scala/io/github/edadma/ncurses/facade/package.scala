package io.github.edadma.ncurses

import io.github.edadma.ncurses.extern.{LibNcurses => nc}

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

package object facade {

  case class MEvent(id: Int, x: Int, y: Int, bstate: Int)

  lazy val stdscr                      = new Window(nc.stdscr)
  lazy val LINES: Int                  = nc.LINES
  lazy val COLS: Int                   = nc.COLS
  lazy val KEY_DOWN: Int               = nc.KEY_DOWN
  lazy val KEY_UP: Int                 = nc.KEY_UP
  lazy val KEY_LEFT: Int               = nc.KEY_LEFT
  lazy val KEY_RIGHT: Int              = nc.KEY_RIGHT
  lazy val KEY_HOME: Int               = nc.KEY_HOME
  lazy val KEY_END: Int                = nc.KEY_END
  lazy val KEY_BACKSPACE: Int          = nc.KEY_BACKSPACE
  lazy val KEY_DC: Int                 = nc.KEY_DC
  lazy val KEY_PPAGE: Int              = nc.KEY_PPAGE
  lazy val KEY_NPAGE: Int              = nc.KEY_NPAGE
  lazy val KEY_IC: Int                 = nc.KEY_IC
  lazy val KEY_STAB: Int               = nc.KEY_STAB
  lazy val KEY_MOUSE: Int              = nc.KEY_MOUSE
  lazy val KEY_F1: Int                 = nc.KEY_F1
  lazy val KEY_F2: Int                 = nc.KEY_F2
  lazy val KEY_F3: Int                 = nc.KEY_F3
  lazy val KEY_F4: Int                 = nc.KEY_F4
  lazy val KEY_F5: Int                 = nc.KEY_F5
  lazy val KEY_F6: Int                 = nc.KEY_F6
  lazy val KEY_F7: Int                 = nc.KEY_F7
  lazy val KEY_F8: Int                 = nc.KEY_F8
  lazy val KEY_F9: Int                 = nc.KEY_F9
  lazy val KEY_F10: Int                = nc.KEY_F10
  lazy val KEY_F11: Int                = nc.KEY_F11
  lazy val KEY_F12: Int                = nc.KEY_F12
  lazy val OK: Int                     = nc.OK
  lazy val ERR: Int                    = nc.ERR
  lazy val A_NORMAL: Int               = nc.A_NORMAL
  lazy val A_STANDOUT: Int             = nc.A_STANDOUT
  lazy val A_UNDERLINE: Int            = nc.A_UNDERLINE
  lazy val A_REVERSE: Int              = nc.A_REVERSE
  lazy val A_BLINK: Int                = nc.A_BLINK
  lazy val A_DIM: Int                  = nc.A_DIM
  lazy val A_BOLD: Int                 = nc.A_BOLD
  lazy val A_PROTECT: Int              = nc.A_PROTECT
  lazy val A_INVIS: Int                = nc.A_INVIS
  lazy val A_ALTCHARSET: Int           = nc.A_ALTCHARSET
  lazy val A_CHARTEXT: Int             = nc.A_CHARTEXT
  lazy val ACS_ULCORNER: Int           = nc.ACS_ULCORNER
  lazy val ACS_LLCORNER: Int           = nc.ACS_LLCORNER
  lazy val ACS_URCORNER: Int           = nc.ACS_URCORNER
  lazy val ACS_LRCORNER: Int           = nc.ACS_LRCORNER
  lazy val ACS_LTEE: Int               = nc.ACS_LTEE
  lazy val ACS_RTEE: Int               = nc.ACS_RTEE
  lazy val ACS_BTEE: Int               = nc.ACS_BTEE
  lazy val ACS_TTEE: Int               = nc.ACS_TTEE
  lazy val ACS_HLINE: Int              = nc.ACS_HLINE
  lazy val ACS_VLINE: Int              = nc.ACS_VLINE
  lazy val ACS_PLUS: Int               = nc.ACS_PLUS
  lazy val ACS_S1: Int                 = nc.ACS_S1
  lazy val ACS_S9: Int                 = nc.ACS_S9
  lazy val ACS_DIAMOND: Int            = nc.ACS_DIAMOND
  lazy val ACS_CKBOARD: Int            = nc.ACS_CKBOARD
  lazy val ACS_DEGREE: Int             = nc.ACS_DEGREE
  lazy val ACS_PLMINUS: Int            = nc.ACS_PLMINUS
  lazy val ACS_BULLET: Int             = nc.ACS_BULLET
  lazy val ACS_LARROW: Int             = nc.ACS_LARROW
  lazy val ACS_RARROW: Int             = nc.ACS_RARROW
  lazy val ACS_DARROW: Int             = nc.ACS_DARROW
  lazy val ACS_UARROW: Int             = nc.ACS_UARROW
  lazy val ACS_BOARD: Int              = nc.ACS_BOARD
  lazy val ACS_LANTERN: Int            = nc.ACS_LANTERN
  lazy val ACS_BLOCK: Int              = nc.ACS_BLOCK
  lazy val ACS_S3: Int                 = nc.ACS_S3
  lazy val ACS_S7: Int                 = nc.ACS_S7
  lazy val ACS_LEQUAL: Int             = nc.ACS_LEQUAL
  lazy val ACS_GEQUAL: Int             = nc.ACS_GEQUAL
  lazy val ACS_PI: Int                 = nc.ACS_PI
  lazy val ACS_NEQUAL: Int             = nc.ACS_NEQUAL
  lazy val ACS_STERLING: Int           = nc.ACS_STERLING
  lazy val ACS_BSSB: Int               = nc.ACS_BSSB
  lazy val ACS_SSBB: Int               = nc.ACS_SSBB
  lazy val ACS_BBSS: Int               = nc.ACS_BBSS
  lazy val ACS_SBBS: Int               = nc.ACS_SBBS
  lazy val ACS_SBSS: Int               = nc.ACS_SBSS
  lazy val ACS_SSSB: Int               = nc.ACS_SSSB
  lazy val ACS_SSBS: Int               = nc.ACS_SSBS
  lazy val ACS_BSSS: Int               = nc.ACS_BSSS
  lazy val ACS_BSBS: Int               = nc.ACS_BSBS
  lazy val ACS_SBSB: Int               = nc.ACS_SBSB
  lazy val ACS_SSSS: Int               = nc.ACS_SSSS
  lazy val ALL_MOUSE_EVENTS: Int       = nc.ALL_MOUSE_EVENTS.toInt
  lazy val BUTTON1_RELEASED: Int       = nc.BUTTON1_RELEASED.toInt
  lazy val BUTTON1_PRESSED: Int        = nc.BUTTON1_PRESSED.toInt
  lazy val BUTTON1_CLICKED: Int        = nc.BUTTON1_CLICKED.toInt
  lazy val BUTTON1_DOUBLE_CLICKED: Int = nc.BUTTON1_DOUBLE_CLICKED.toInt
  lazy val BUTTON1_TRIPLE_CLICKED: Int = nc.BUTTON1_TRIPLE_CLICKED.toInt
  lazy val BUTTON2_RELEASED: Int       = nc.BUTTON2_RELEASED.toInt
  lazy val BUTTON2_PRESSED: Int        = nc.BUTTON2_PRESSED.toInt
  lazy val BUTTON2_CLICKED: Int        = nc.BUTTON2_CLICKED.toInt
  lazy val BUTTON2_DOUBLE_CLICKED: Int = nc.BUTTON2_DOUBLE_CLICKED.toInt
  lazy val BUTTON2_TRIPLE_CLICKED: Int = nc.BUTTON2_TRIPLE_CLICKED.toInt
  lazy val BUTTON_CTRL: Int            = nc.BUTTON_CTRL.toInt
  lazy val BUTTON_SHIFT: Int           = nc.BUTTON_SHIFT.toInt
  lazy val BUTTON_ALT: Int             = nc.BUTTON_ALT.toInt
  lazy val REPORT_MOUSE_POSITION: Int  = nc.REPORT_MOUSE_POSITION.toInt
  lazy val COLOR_BLACK: Int            = nc.COLOR_BLACK
  lazy val COLOR_RED: Int              = nc.COLOR_RED
  lazy val COLOR_GREEN: Int            = nc.COLOR_GREEN
  lazy val COLOR_YELLOW: Int           = nc.COLOR_YELLOW
  lazy val COLOR_BLUE: Int             = nc.COLOR_BLUE
  lazy val COLOR_MAGENTA: Int          = nc.COLOR_MAGENTA
  lazy val COLOR_CYAN: Int             = nc.COLOR_CYAN
  lazy val COLOR_WHITE: Int            = nc.COLOR_WHITE

  private[facade] def varargs(args: Seq[Any])(implicit z: Zone) =
    toCVarArgList(
      args
        map {
          case s: String => CVarArg.materialize(toCString(s))
          case n: Int    => CVarArg.materialize(n)
          case n: Long   => CVarArg.materialize(n)
          case n: Double => CVarArg.materialize(n)
        })

  def initscr: Window = new Window(nc.initscr)

  def cbreak: Int = nc.cbreak

  def raw: Int = nc.raw

  def noecho: Int = nc.noecho

  def endwin: Int = nc.endwin

  def bkgdset(ch: Int): Unit = nc.bkgdset(ch.toUInt)

  def bkgd(ch: Int): Unit = nc.bkgd(ch.toUInt)

  def start_color: Int = nc.start_color

  def addstr(s: String): Int = Zone(implicit z => nc.addstr(toCString(s)))

  def addstr(y: Int, x: Int, str: String): Int = Zone(implicit z => nc.mvaddstr(y, x, toCString(str)))

  def addstr(str: String, n: Int): Int = Zone(implicit z => nc.addnstr(toCString(str), n))

  def addstr(y: Int, x: Int, str: String, n: Int): Int = Zone(implicit z => nc.mvaddnstr(y, x, toCString(str), n))

  def addch(ch: Int): Int = nc.addch(ch.toUInt)

  def addch(x: Int, n: Int, ch: Int): Int = nc.mvaddch(x, n, ch.toUInt)

  def echochar(ch: Int): CInt = nc.echochar(ch.toUInt)

  def refresh: Int = nc.refresh

  def getch: Int = nc.getch

  def move(y: Int, x: Int): Int = nc.move(y, x)

  def scrl(n: Int): Int = nc.scrl(n)

  def printw(fmt: String, args: Any*): Int = stdscr.printw(fmt, args: _*)

  def printw(y: Int, x: Int, fmt: String, args: Any*): Int = {
    move(y, x)
    printw(fmt, args: _*)
  }

  def newwin(nlines: Int, ncols: Int, begin_y: Int, begin_x: Int): Window =
    new Window(nc.newwin(nlines, ncols, begin_y, begin_x))

  def new_panel(win: Window): Panel = new Panel(nc.new_panel(win.win))

  def keyname(c: Int): String = fromCString(nc.keyname(c))

  def update_panels(): Unit = nc.update_panels()

  def doupdate: Int = nc.doupdate

  def clrtoeol: Int = nc.clrtoeol

  def clrtobot: Int = nc.clrtobot

  def clear: Int = nc.clear

  def attron(attrs: Int): Int = nc.attron(attrs)

  def attroff(attrs: Int): Int = nc.attroff(attrs)

  def COLOR_PAIR(c: Int): Int = nc.COLOR_PAIR(c)

  def curs_set(visibility: Int): Int = nc.curs_set(visibility)

  def getstr(n: Int): (Int, String) = stdscr.getstr(n)

  def getstr(y: Int, x: Int, n: Int): (Int, String) = {
    move(y, x)
    getstr(n)
  }

  def chgat(n: Int, attr: Int, pair: Short): Int = nc.chgat(n, attr.toUInt, pair, null)

  def chgat(y: Int, x: Int, n: Int, attr: Int, pair: Short): Int = nc.mvchgat(y, x, n, attr.toUInt, pair, null)

  def hline(y: Int, x: Int, ch: Int, n: Int): Int = nc.mvhline(y, x, ch.toUInt, n)

  def vline(y: Int, x: Int, ch: Int, n: Int): Int = nc.mvvline(y, x, ch.toUInt, n)

  def mousemask(newmask: Int): (Int, Int) = {
    val oldmask = stackalloc[CUnsignedInt]

    (nc.mousemask(newmask.toUInt, oldmask).toInt, (!oldmask).toInt)
  }

  def mouseinterval(interval: Int): Int = nc.mouseinterval(interval)

  def getmouse: (Int, MEvent) = {
    val event = stackalloc[nc.MEVENT]

    (nc.getmouse(event), MEvent(event._1, event._2, event._3, event._5.toInt))
  }

  def has_colors: Boolean = nc.has_colors

  def init_color(color: Short, r: Short, g: Short, b: Short): Int = nc.init_color(color, r, g, b)

  def mouse_trafo(y: Int, x: Int, to_screen: Boolean): (Boolean, Int, Int) = {
    val py = stackalloc[CInt]
    val px = stackalloc[CInt]

    !py = y
    !px = x
    (nc.mouse_trafo(py, px, to_screen), !py, !px)
  }

  def def_prog_mode: Int = nc.def_prog_mode

  def reset_prog_mode: Int = nc.def_prog_mode

  def erase: Int = nc.erase

  def beep: Int = nc.beep

  def flash: Int = nc.flash

  def border(ls: Int, rs: Int, ts: Int, bs: Int, tl: Int, tr: Int, bl: Int, br: Int): Int =
    nc.border(ls.toUInt, rs.toUInt, ts.toUInt, bs.toUInt, tl.toUInt, tr.toUInt, bl.toUInt, br.toUInt)

  def has_mouse: Boolean = nc.has_mouse

  def use_default_colors: Int = nc.use_default_colors

  def assume_default_colors(fg: Int, bg: Int): Int = nc.assume_default_colors(fg, bg)

}
