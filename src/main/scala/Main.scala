//import io.github.edadma.ncurses._
//
//object Main extends App {
//  initscr
//  move(0, 9)
//  addstr("90123456789")
//  getch
//
//  val w = newwin(5, 9, 0, 0)
//
//  w.addstr("012345678")
//  w.getch
//  w.move(0, 4)
//  w.addch('\n')
//  w.getch
//  w.delwin
//  endwin
//}

//ex 1
import io.github.edadma.ncurses._

object Main extends App {
  initscr /* Start curses mode */
  printw("Hello World !!!") /* Print Hello World */
  refresh /* Print it on to the real screen */
  getch /* Wait for user input */
  endwin /* End curses mode */
}

//ex 4
//import io.github.edadma.ncurses._
//
//object Main extends App {
//
//  try {
//    initscr
//
//    val mesg         = "Enter a string: "
//    val (rows, cols) = stdscr.getmaxyx
//
//    printw(rows / 2, (cols - mesg.length) / 2, "%s", mesg)
//
//    val (_, str) = getstr(20)
//
//    noecho
//    curs_set(0)
//    addstr(LINES - 1, 0, s"You entered: $str")
//    getch
//  } catch {
//    case e: Exception =>
//      endwin
//      e.printStackTrace()
//      sys.exit(1)
//  }
//
//  endwin
//
//}

//ex 11
//import io.github.edadma.ncurses._
//
//object Main extends App {
//  val WIDTH  = 30
//  val HEIGHT = 10
//
//  val choices = Vector("Choice 1", "Choice 2", "Choice 3", "Choice 4", "Exit")
//
//  val n_choices = choices.length
//  var choice    = 0
//
//  /* Initialize curses */
//  initscr
//  clear
//  noecho
//  cbreak //Line buffering disabled. pass on everything
//
//  /* Try to put the window in the middle of screen */
//  val startx = (COLS - WIDTH) / 2
//  val starty = (LINES - HEIGHT) / 2
//
//  attron(A_REVERSE)
//  printw(LINES - 1, 1, "Click on Exit to quit (Works best in a virtual console)")
//  refresh
//  attroff(A_REVERSE)
//
//  /* Print the menu for the first time */
//  val menu_win = newwin(HEIGHT, WIDTH, starty, startx)
//
//  menu_win.keypad(true)
//  print_menu(menu_win, 1)
//
//  /* Get all the mouse events */
//  mousemask(ALL_MOUSE_EVENTS)
//  mouseinterval(0)
//
//  while (true) {
//    menu_win.getch match {
//      case `KEY_MOUSE` =>
//        val (res, event) = getmouse
//
//        if (res == OK)
//          /* When the user clicks left mouse button */
//          if ((event.bstate & BUTTON1_PRESSED) != 0) {
//            choice = report_choice(event.x + 1, event.y + 1).getOrElse(choice)
//
//            if (choice == -1) { //Exit chosen
//              endwin
//              sys.exit()
//            }
//
//            printw(LINES - 2, 1, "Choice made is : %d String Chosen is \"%10s\"", choice, choices(choice - 1))
//            refresh
//          }
//
//        print_menu(menu_win, choice)
//      case _ =>
//    }
//  }
//
//  def print_menu(menu_win: Window, highlight: Int): Unit = {
//    val x = 2
//    var y = 2
//
//    menu_win.box(0, 0)
//
//    for (i <- 0 until n_choices) {
//      if (highlight == i + 1) {
//        menu_win.attron(A_REVERSE)
//        menu_win.printw(y, x, "%s", choices(i))
//        menu_win.attroff(A_REVERSE)
//      } else
//        menu_win.printw(y, x, "%s", choices(i))
//      y += 1
//    }
//
//    menu_win.refresh
//  }
//
//  /* Report the choice according to mouse position */
//  def report_choice(mouse_x: Int, mouse_y: Int): Option[Int] = {
//    val i = startx + 2
//    val j = starty + 3
//
//    for (choice <- 0 until n_choices)
//      if (mouse_y == j + choice && mouse_x >= i && mouse_x <= i + choices(choice).length)
//        if (choice == n_choices - 1)
//          return Some(-1)
//        else
//          return Some(choice + 1)
//
//    None
//  }
//}

//import io.github.edadma.ncurses._
//
//object Main extends App {
//
//  val NLINES = 10
//  val NCOLS  = 40
//
//  /* Initialize curses */
//  initscr
//  start_color
//  cbreak
//  noecho
//  stdscr.keypad(true)
//
//  /* Initialize all the colors */
//  init_pair(1, COLOR_RED, COLOR_BLACK)
//  init_pair(2, COLOR_GREEN, COLOR_BLACK)
//  init_pair(3, COLOR_BLUE, COLOR_BLACK)
//  init_pair(4, COLOR_CYAN, COLOR_BLACK)
//
//  val my_wins = init_wins(3)
//
//  /* Attach a panel to each window */
//  /* Order is bottom up */
//  val my_panels = my_wins map new_panel
//
//  /* Set up the user pointers to the next panel */
//  for (i <- my_panels.indices)
//    my_panels(i).set_panel_userptr(my_panels((i + 1) % my_panels.length))
//
//  /* Update the stacking order. 2nd panel will be on top */
//  update_panels()
//
//  /* Show it on the screen */
//  attron(COLOR_PAIR(4))
//  printw(LINES - 2, 0, "Use tab to browse through the windows (F1 to Exit)")
//  attroff(COLOR_PAIR(4))
//  doupdate
//
//  var top     = my_panels(2)
//  var ch: Int = _
//
//  while ({ ch = getch; ch != KEY_F1 }) {
//    ch match {
//      case '\t' =>
//        top = top.panel_userptr
//        top.top_panel
//      case _ =>
//    }
//
//    update_panels()
//    doupdate
//  }
//
//  endwin
//
//  /* Put all the windows */
//  def init_wins(n: Int): Seq[Window] = {
//    var y = 2
//    var x = 10
//
//    for (i <- 0 until n)
//      yield {
//        val win = newwin(NLINES, NCOLS, y, x)
//
//        win_show(win, s"Window Number ${i + 1}", i + 1)
//        y += 3
//        x += 7
//        win
//      }
//  }
//
//  /* Show the window with a border and a label */
//  def win_show(win: Window, label: String, label_color: Int): Unit = {
//    val width = win.getmaxx
//
//    win.box(0, 0)
//    win.addch(2, 0, ACS_LTEE)
//    win.hline(2, 1, ACS_HLINE, width - 2)
//    win.addch(2, width - 1, ACS_RTEE)
//    print_in_middle(win, 1, 0, width, label, COLOR_PAIR(label_color))
//  }
//
//  def print_in_middle(win: Window, starty: Int, startx: Int, width: Int, string: String, color: Int): Unit = {
//    val y = if (starty != 0) starty else win.getcury
//    val x = startx + (width - string.length) / 2
//
//    win.attron(color)
//    win.printw(y, x, "%s", string)
//    win.attroff(color)
//    refresh
//  }
//
//}
