import xyz.hyperreal.ncurses.facade._

object Main extends App {

  try {
    initscr

    val mesg         = "Enter a string: "
    val (rows, cols) = stdscr.getmaxyx

    mvprintw(rows / 2, (cols - mesg.length) / 2, "%s", mesg)

    val (_, str) = getnstr(20)

    noecho
    curs_set(0)
    mvaddstr(rows - 1, 0, s"You entered: $str")
    getch
  } catch {
    case e: Exception =>
      endwin
      e.printStackTrace()
      sys.exit(1)
  }

  endwin

}
