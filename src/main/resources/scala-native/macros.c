#include <ncurses.h>

int ncurses_refresh() { return refresh(); }
int ncurses_getch() { return getch(); }
int ncurses_move(int y, int x) { return move(y, x); }
int ncurses_addstr(char* str) { return addstr(str); }
int ncurses_KEY_DOWN() { return KEY_DOWN; }
int ncurses_KEY_UP() { return KEY_UP; }
int ncurses_KEY_LEFT() { return KEY_LEFT; }
int ncurses_KEY_RIGHT() { return KEY_RIGHT; }
int ncurses_KEY_HOME() { return KEY_HOME; }
int ncurses_KEY_BACKSPACE() { return KEY_BACKSPACE; }
int ncurses_KEY_DC() { return KEY_DC; }
int ncurses_clrtoeol() { return clrtoeol(); }
int ncurses_clrtobot() { return clrtobot(); }
int ncurses_getmaxy(WINDOW* win) { return getmaxy(win); }
int ncurses_getmaxx(WINDOW* win) { return getmaxx(win); }
int ncurses_clear() { return clear(); }
int ncurses_OK() { return OK; }
int ncurses_ERR() { return ERR; }
