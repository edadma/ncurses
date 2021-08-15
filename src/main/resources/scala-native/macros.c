#include <ncurses.h>

int ncurses_refresh() { return refresh(); }

int ncurses_getch() { return getch(); }

int ncurses_move(y: int, x: int) { return move(y, x); }