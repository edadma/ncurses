ncurses
=======

*ncurses* provides Scala Native bindings for the GNU Ncurses library.  This package is a work in progress as there are hundreds of functions in the Ncurses library.  Nonetheless, this package is quite usable as is.  `libncurses-dev` needs to be installed.

Overview
--------

The entire "Scala-esque" part of this library is found in the `xyz.hyperreal.ncurses.facade` package.  That's the only package you need to import from, as seen in the example below.  The other package in the library is `xyz.hyperreal.ncurses.extern` which provides for interaction with the Ncurses C library using Scala Native interoperability elements from the so-call `unsafe` namespace.  There are no public declarations in the `xyz.hyperreal.ncurses.facade` package that use `unsafe` types in their parameter or return types, making it a pure Scala facade.  Specifically, you never have to worry about memory allocation or type conversions.

Obligatory "Hello World" example
--------------------------------

The following basic example, which asks the user to type something and then displays what was entered, shows a typical use of the library.

```scala
import xyz.hyperreal.ncurses.facade._

object Main extends App {

  try {
    initscr
    raw

    val prompt       = "Type something: "
    val (rows, cols) = stdscr.getmaxyx

    mvaddstr(rows / 2, (cols - prompt.length) / 2, prompt)

    val (_, s) = getnstr(20)

    noecho
    curs_set(0)
    mvaddstr(rows - 1, 0, s"You entered: $s")
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

The official documentation for the Ncurses library can be found at [ncurses][https://invisible-island.net/ncurses/man/ncurses.3x.html]. The official documentation for the extension libraries can be found at [panel][https://invisible-island.net/ncurses/man/panel.3x.html], [menu][https://invisible-island.net/ncurses/man/menu.3x.html], and [form][https://invisible-island.net/ncurses/man/form.3x.html].

Guidelines
----------

In these guidelines, the phrase *library function* refers to the GNU Ncurses C library function that corresponds to the *wrapper method* being described.

There are hundreds of functions in the GNU Ncurses C library.  Therefore, in order to be able to find library documentation corresponding to a given wrapper method or, vice versa, in order to know which wrapper method corresponds to a given library function, there needs to be clear method naming guidelines.  Also, in the case where wrapper methods have a different number of parameters or return values (in the cases where wrapper methods return a tuple) from their library function counterparts, there needs to be clear method parameter and return type guidelines.

### Methods that return a tuple

There are a few wrapper methods that return a tuple. If the library function has a return value, then the first component of that tuple shall be the library function return value. The remaining components shall be values that are returned via pointer arguments to the library function.

### Value class method names

The Ncurses library already follows a certain naming convention fairly consistently:
- function names prefixed with "w" are window operations
- function names prefixed with "mv" are output operations that also move the cursor to a new position first
- function names prefixed with "mvw" are a combination of the above
- in many, but not all cases function names prefixed with "w" and "mvw" have corresponding `stdscr` functions without the "w" in the name prefix.

The guideline being followed here is that window operation functions with a "w" in their prefix that have a corresponding `stdscr` version of the function (without the "w"), shall have a corresponding `Window` wrapper method that drops the "w" in the name prefix. However, window operation functions with a "w" in their prefix that do not have a corresponding `stdscr` version of the function at all shall keep the "w" in the name prefix.  This rule makes it easier to look up documentation for corresponding library functions. 

### Value class method parameters

All value class methods correspond to library functions whose first parameter has a pointer type corresponding to the underlying runtime pointer type of the value class.  Therefore, the wrapper method doesn't have that first parameter.
