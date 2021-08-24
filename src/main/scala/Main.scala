//import xyz.hyperreal.ncurses.facade._
//
//object Main extends App {
//
//  try {
//    initscr
//
//    val mesg         = "Enter a string: "
//    val (rows, cols) = stdscr.getmaxyx
//
//    mvprintw(rows / 2, (cols - mesg.length) / 2, "%s", mesg)
//
//    val (_, str) = getnstr(20)
//
//    noecho
//    curs_set(0)
//    mvaddstr(LINES - 1, 0, s"You entered: $str")
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

import xyz.hyperreal.ncurses.facade._

import scala.collection.immutable.ArraySeq

object Main extends App {
  val WIDTH  = 30
  val HEIGHT = 10

  val startx = 0
  val starty = 0

    val choices =
    ArraySeq(
    "Choice 1"
  ,
"Choice 2",
"Choice 3",
"Choice 4",
"Exit")

val n_choices = choices.length
var c, choice = 0

/* Initialize curses */
initscr
clear
noecho
cbreak //Line buffering disabled. pass on everything

/* Try to put the window in the middle of screen */
val startx = (COLS - WIDTH) / 2
val starty = (LINES - HEIGHT) / 2

attron(A_REVERSE)
mvprintw(LINES - 1, 1, "Click on Exit to quit (Works best in a virtual console)")
refresh
attroff(A_REVERSE)

/* Print the menu for the first time */
val menu_win = newwin(HEIGHT, WIDTH, starty, startx)

  menu_win.keypad(true)
print_menu(menu_win, 1)

/* Get all the mouse events */
mousemask(ALL_MOUSE_EVENTS)
mouseinterval(0)

while (true) {
  c = menu_win.getch

  c match {
    case `KEY_MOUSE` =>
      val (res, event) = getmouse

      if (res == OK) { /* When the user clicks left mouse button */
        if (event.bstate & BUTTON1_PRESSED) {
          report_choice(event.x + 1, event.y + 1, &choice);
          if (choice == -1) { //Exit chosen
            endwin
            sys.exit
          }

          mvprintw(LINES - 2, 1, "Choice made is : %d String Chosen is \"%10s\"", choice, choices(choice - 1));
          refresh
        }
      }
        print_menu(menu_win, choice);
  }
}
}


def print_menu(menu_win: Window,  highlight: Int) {
var x, y, i: Int

x = 2;
y = 2;
box(menu_win, 0, 0);
for (i = 0; i < n_choices; ++i) {
  if (highlight == i + 1) {
    wattron(menu_win, A_REVERSE);
    mvwprintw(menu_win, y, x, "%s", choices[i]);
    wattroff(menu_win, A_REVERSE);
  } else
    mvwprintw(menu_win, y, x, "%s", choices[i]);
  ++y;
}
wrefresh(menu_win);
}

/* Report the choice according to mouse position */
void report_choice(int mouse_x, int mouse_y, int *p_choice) {
int i, j, choice;

i = startx + 2;
j = starty + 3;

for (choice = 0; choice < n_choices; ++choice)
if (mouse_y == j + choice && mouse_x >= i && mouse_x <= i + strlen(choices[choice])) {
  if (choice == n_choices - 1)
    *p_choice = -1;
  else
    *p_choice = choice + 1;
  break;
}
}
