import xyz.hyperreal.ncurses._

object Main extends App {

  try {
    initscr
    printw("%s\n", "Scala Native is awesome!")
    addch('!')
    getch
  } catch {
    case e: Exception =>
      endwin
      e.printStackTrace()
  }

  endwin

}
