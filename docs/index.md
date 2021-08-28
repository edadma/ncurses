ncurses
=======

*ncurses* provides Scala Native bindings for the [GNU Ncurses C library](https://invisible-island.net/ncurses/announce.html).

Overview
--------

The goal of this project is to provide an easy-to-use Scala Native facade for the entire Ncurses C library, including the [panel](https://invisible-island.net/ncurses/man/panel.3x.html), [menu](https://invisible-island.net/ncurses/man/menu.3x.html) and [form](https://invisible-island.net/ncurses/man/form.3x.html) extension libraries, which are bundled with the main *ncurses* library. This project is active and will be kept up-to-date with respect to new Scala Native releases.

The more "programmer friendly" part of this library is found in the `io.github.edadma.ncurses.facade` package.  That's the only package you need to import from, as seen in the examples below.  The other package in the library is `io.github.edadma.ncurses.extern` which provides for interaction with the Ncurses C library using Scala Native interoperability elements from the so-call `unsafe` namespace.  There are no public declarations in the `io.github.edadma.ncurses.facade` package that use `unsafe` types in their parameter or return types, making it a pure Scala facade.  Consequently, you never have to worry about memory allocation or type conversions.

### Efficient screen output

All facade classes that relate to screen output are [Scala value classes](https://docs.scala-lang.org/overviews/core/value-classes.html) which means that we can have a nice "Scala-esque" facade without sacrificing efficiency. Thanks to Scala's value classes, we can wrap native pointers to Ncurses data structures without the overhead of object instantiation.

There is one facade class relating to responding to mouse events that is not a value class, but it only gets instantiated when there's a mouse click and therefore does not affect screen output efficiency.

### Library coverage and usability

Currently, a large part of the basic [Ncurses](https://invisible-island.net/ncurses/man/ncurses.3x.html) library is covered, as well as most of the "panel" library.  Each subsequent release will see more ncurses functions and variables added, and each minor release will include support for another extension library (support for menus is next).

As it stands now, this library is very usable and can be used to implement a wide variety of terminal applications in Scala.  Of course, as with any terminal application, the terminal emulator that you run it on can make a difference.  The terminal inside [IntelliJ](https://www.jetbrains.com/idea/), for instance doesn't do mouse events, so to really test the library, I've been using [Tilix](https://gnunn1.github.io/tilix-web/) which has been working great.

Usage
-----

To use this library, `libncurses-dev` needs to be installed:

```shell
sudo apt install libncurses-dev
```

Include the following in your `build.sbt`:

```scala
resolvers += Resolver.githubPackages("edadma")

libraryDependencies += "io.github.edadma" %%% "ncurses" % "0.2.2"
```

Use the following `import` in your code:

```scala
import io.github.edadma.ncurses.facade._
```

Examples
--------

The following examples are taken from the well-known [NCURSES Programming HOWTO](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/) with only slight changes where needed.

### [Example 1](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/helloworld.html)

The obligatory "Hello World" example.

```scala
import io.github.edadma.ncurses.facade._

object Main extends App {
  initscr                     /* Start curses mode */
  printw("Hello World !!!");  /* Print Hello World */
  refresh                     /* Print it on to the real screen */
  getch                       /* Wait for user input */
  endwin                      /* End curses mode */
}
```

### [Example 4](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/scanw.html)

Basic keyboard input example.

```scala
import io.github.edadma.ncurses.facade._

object Main extends App {

  try {
    initscr

    val mesg         = "Enter a string: "
    val (rows, cols) = stdscr.getmaxyx

    printw(rows / 2, (cols - mesg.length) / 2, "%s", mesg)

    val (_, str) = getstr(20)

    noecho
    curs_set(0)
    addstr(LINES - 1, 0, s"You entered: $str")
    getch
  } catch {
    case e: Exception =>
      endwin
      e.printStackTrace()
      sys.exit(1)
  }

  endwin

}
```

### [Example 11](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/mouse.html)

Basic mouse input example.

```scala
import io.github.edadma.ncurses.facade._

object Main extends App {
  val WIDTH  = 30
  val HEIGHT = 10

  val choices = Vector("Choice 1", "Choice 2", "Choice 3", "Choice 4", "Exit")

  val n_choices = choices.length
  var choice    = 0

  /* Initialize curses */
  initscr
  clear
  noecho
  cbreak //Line buffering disabled. pass on everything

  /* Try to put the window in the middle of screen */
  val startx = (COLS - WIDTH) / 2
  val starty = (LINES - HEIGHT) / 2

  attron(A_REVERSE)
  printw(LINES - 1, 1, "Click on Exit to quit (Works best in a virtual console)")
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
    menu_win.getch match {
      case `KEY_MOUSE` =>
        val (res, event) = getmouse

        if (res == OK)
          /* When the user clicks left mouse button */
          if ((event.bstate & BUTTON1_PRESSED) != 0) {
            choice = report_choice(event.x + 1, event.y + 1).getOrElse(choice)

            if (choice == -1) { //Exit chosen
              endwin
              sys.exit()
            }

            printw(LINES - 2, 1, "Choice made is : %d String Chosen is \"%10s\"", choice, choices(choice - 1))
            refresh
          }

        print_menu(menu_win, choice)
      case _ =>
    }
  }

  def print_menu(menu_win: Window, highlight: Int): Unit = {
    val x = 2
    var y = 2

    menu_win.box(0, 0)

    for (i <- 0 until n_choices) {
      if (highlight == i + 1) {
        menu_win.attron(A_REVERSE);
        menu_win.printw(y, x, "%s", choices(i));
        menu_win.attroff(A_REVERSE);
      } else
        menu_win.printw(y, x, "%s", choices(i));
      y += 1
    }

    menu_win.refresh
  }

  /* Report the choice according to mouse position */
  def report_choice(mouse_x: Int, mouse_y: Int): Option[Int] = {
    val i = startx + 2
    val j = starty + 3

    for (choice <- 0 until n_choices)
      if (mouse_y == j + choice && mouse_x >= i && mouse_x <= i + choices(choice).length)
        if (choice == n_choices - 1)
          return Some(-1)
        else
          return Some(choice + 1)

    None
  }
}
```

Ncurses C library documentation
-------------------------------

The official documentation for the Ncurses library can be found at [ncurses](https://invisible-island.net/ncurses/man/ncurses.3x.html). The official documentation for the extension libraries can be found at [panel](https://invisible-island.net/ncurses/man/panel.3x.html), [menu](https://invisible-island.net/ncurses/man/menu.3x.html), and [form](https://invisible-island.net/ncurses/man/form.3x.html).

Guidelines
----------

In these guidelines, the phrase *library function/variable* refers to the GNU Ncurses C library function/variable that has a counterpart in this library.  Likewise, the phrase *facade method/variable/constant/declaration* refers to a method/variable/constant in this library that has a counterpart in the GNU Ncurses library.

There are hundreds of functions in the GNU Ncurses C library.  Therefore, in order to be able to find library documentation corresponding to a given facade declaration or, vice versa, in order to know which facade declaration corresponds to a given library function or variable, there needs to be clear method naming guidelines.  Also, in the case where facade methods have a different number of parameters or return values (in the cases where facade methods return a tuple) from their library function counterparts, there needs to be clear method parameter and return type guidelines.

The following are the guidelines being adhered to.

### Naming

In general, the names of nearly all facade declarations shall be exactly the same as their library counterparts.  This guideline will make it easier to lookup documentation for a given library function or variable.  And, vice versa, this will make it easy to know the name for a facade counterpart to a given library function or variable.  There are a number of exceptions to this guideline arising from the "Value class method names" and "Overloaded method variants" guidelines, however because of how the GNU Ncurses library documentation is organized, those exceptions won't cause a problem in finding relevant documentation.

### Methods that return a tuple

There are a few facade methods that return a tuple. If the library function has a return value, then the first component of that tuple shall be the library function return value. The remaining components shall be values that are returned via pointer arguments to the library function.

### Value class method names

The Ncurses library already follows a certain naming convention fairly consistently:
- function names prefixed with "w" are window operations
- function names prefixed with "mv" are output operations that also move the cursor to a new position first
- function names prefixed with "mvw" are a combination of the above
- in many, but not all cases function names prefixed with "w" and "mvw" have corresponding `stdscr` functions without the "w" in the name prefix.

The guideline being followed here is that window operation functions with a "w" in their prefix that have a corresponding `stdscr` version of the function (without the "w"), shall have a corresponding `Window` facade method that drops the "w" in the name prefix. However, window operation functions with a "w" in their prefix that do not have a corresponding `stdscr` version of the function at all shall keep the "w" in the name prefix.  This rule makes it easier to look up documentation for corresponding library functions.

### Overloaded method variants

As mentioned above, the Ncurses library tends to follow a function naming convention for variants of the same operation. In cases where these variants can be overloaded in Scala, the base name (i.e. without the extra prefix or infix letters) shall be used throughout. An example of this is the large number of functions such as `addstr`/`mvaddstr` that have variants with and without the 'mv' prefix.  There are also pairs of functions with infix naming variants such as `addstr`/`addnstr` that can be overloaded.

This guideline shall not apply in cases where the resulting name doesn't appear in the official Ncurses C library documentation.  

### Value class method parameters

All value class methods correspond to library functions whose first parameter has a pointer type corresponding to the underlying runtime pointer type of the value class.  Therefore, the facade method doesn't have that first parameter.
