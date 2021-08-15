#include <ncurses.h>

int ncurses_refresh() { return refresh(); }

int ncurses_getch() { return getch(); }

int ncurses_move(int y, int x) { return move(y, x); }

int ncurses_addstr(char* str) { return addstr(str); }
