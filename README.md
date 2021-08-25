ncurses
=======

*ncurses* provides Scala Native bindings for the GNU Ncurses C library.

Overview
--------

The entire "Scala-esque" part of this library is found in the `xyz.hyperreal.ncurses.facade` package.  That's the only package you need to import from, as seen in the examples below.  The other package in the library is `xyz.hyperreal.ncurses.extern` which provides for interaction with the Ncurses C library using Scala Native interoperability elements from the so-call `unsafe` namespace.  There are no public declarations in the `xyz.hyperreal.ncurses.facade` package that use `unsafe` types in their parameter or return types, making it a pure Scala facade.  Specifically, you never have to worry about memory allocation or type conversions.

All facade classes that relate to screen output are [Scala value classes](https://docs.scala-lang.org/overviews/core/value-classes.html) which means that we can have a nice "Scala-esque" facade without sacrificing efficiency. Thanks to Scala's value classes, we can wrap native pointers to Ncurses data structures without the overhead of object instantiation.

There is a facade class relating to responding to mouse events that is not a value class, but it only gets instantiated when there's a mouse click and therefore does not affect screen output efficiency.

Usage
-----

`libncurses-dev` needs to be installed.

Examples
--------

The following examples are taken from the well-known [NCURSES Programming HOWTO](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/) with only slight changes where needed.

### [Example 1](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/helloworld.html) (the obligatory "Hello World" example)

```scala
import xyz.hyperreal.ncurses.facade._

object Main extends App {
  initscr                     /* Start curses mode */
  printw("Hello World !!!");  /* Print Hello World */
  refresh                     /* Print it on to the real screen */
  getch                       /* Wait for user input */
  endwin                      /* End curses mode */
}
```

### [Example 4](https://tldp.org/HOWTO/NCURSES-Programming-HOWTO/scanw.html)

```scala
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
    mvaddstr(LINES - 1, 0, s"You entered: $str")
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

Ncurses C library documentation
-------------------------------

The official documentation for the Ncurses library can be found at [ncurses](https://invisible-island.net/ncurses/man/ncurses.3x.html). The official documentation for the extension libraries can be found at [panel](https://invisible-island.net/ncurses/man/panel.3x.html), [menu](https://invisible-island.net/ncurses/man/menu.3x.html), and [form](https://invisible-island.net/ncurses/man/form.3x.html).

Guidelines
----------

In these guidelines, the phrase *library function* refers to the GNU Ncurses C library function that has a corresponding method in this library.  Likewise, the phrase *facade method* refers to a method in this library that has a corresponding function in the GNU Ncurses library.

There are hundreds of functions in the GNU Ncurses C library.  Therefore, in order to be able to find library documentation corresponding to a given facade method or, vice versa, in order to know which facade method corresponds to a given library function, there needs to be clear method naming guidelines.  Also, in the case where facade methods have a different number of parameters or return values (in the cases where facade methods return a tuple) from their library function counterparts, there needs to be clear method parameter and return type guidelines.

The following are the guidelines being adhered to.

### Naming

In general, the names of almost all facade methods, variables and constants shall be exactly the same as their library counterparts.  This guideline will make it easier to lookup documentation for a given library function or variable.  And, vice versa, this will make it easy to know the name for a facade counterpart to a given library function or variable.  There are a number of exceptions to this guideline arising from the "Value class method names" guideline.

Because of how the GNU Ncurses library documentation is organized, the exceptions mentioned above won't cause a problem in finding relevant documentation.

### Methods that return a tuple

There are a few facade methods that return a tuple. If the library function has a return value, then the first component of that tuple shall be the library function return value. The remaining components shall be values that are returned via pointer arguments to the library function.

### Value class method names

The Ncurses library already follows a certain naming convention fairly consistently:
- function names prefixed with "w" are window operations
- function names prefixed with "mv" are output operations that also move the cursor to a new position first
- function names prefixed with "mvw" are a combination of the above
- in many, but not all cases function names prefixed with "w" and "mvw" have corresponding `stdscr` functions without the "w" in the name prefix.

The guideline being followed here is that window operation functions with a "w" in their prefix that have a corresponding `stdscr` version of the function (without the "w"), shall have a corresponding `Window` facade method that drops the "w" in the name prefix. However, window operation functions with a "w" in their prefix that do not have a corresponding `stdscr` version of the function at all shall keep the "w" in the name prefix.  This rule makes it easier to look up documentation for corresponding library functions. 

### Value class method parameters

All value class methods correspond to library functions whose first parameter has a pointer type corresponding to the underlying runtime pointer type of the value class.  Therefore, the facade method doesn't have that first parameter.
