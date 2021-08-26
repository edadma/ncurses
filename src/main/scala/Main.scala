import io.github.edadma.ncurses.facade._

object Main extends App {
  initscr
  printw(2, 1, "asdf %d ", 123)
  printw("zxcv %d", 123)
  getch
  endwin
}

//ex 1
//import io.github.edadma.ncurses.facade._
//
//object Main extends App {
//  initscr /* Start curses mode */
//  printw("Hello World !!!"); /* Print Hello World */
//  refresh /* Print it on to the real screen */
//  getch /* Wait for user input */
//  endwin /* End curses mode */
//}

//ex 4
//import io.github.edadma.ncurses.facade._
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
//    val (_, str) = getnstr(20)
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
//import io.github.edadma.ncurses.facade._
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
//        menu_win.attron(A_REVERSE);
//        menu_win.printw(y, x, "%s", choices(i));
//        menu_win.attroff(A_REVERSE);
//      } else
//        menu_win.printw(y, x, "%s", choices(i));
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
