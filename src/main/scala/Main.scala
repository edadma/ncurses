import xyz.hyperreal.ncurses._

object Main extends App {

  try {
    initscr

    val win = newwin(10, 30, 0, 0)

    win.printw("%s\n", "Scala Native is awesome!")
    win.mvaddstr(3, 0, "asdf")
    win.getch
    win.delwin
  } catch {
    case e: Exception =>
      endwin
      e.printStackTrace()
  }

  endwin

}
