#include <ncurses.h>

int ncurses_define_refresh() { return refresh(); }

int ncurses_define_getch() { return getch(); }
