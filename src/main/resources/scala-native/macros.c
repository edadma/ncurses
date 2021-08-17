#include <ncurses.h>

int ncurses_refresh() { return refresh(); }
int ncurses_getch() { return getch(); }
int ncurses_move(int y, int x) { return move(y, x); }
int ncurses_addstr(char* str) { return addstr(str); }
int ncurses_waddstr(WINDOW* win, char* str) { return waddstr(win, str); }
int ncurses_clrtoeol() { return clrtoeol(); }
int ncurses_clrtobot() { return clrtobot(); }
int ncurses_getmaxy(WINDOW* win) { return getmaxy(win); }
int ncurses_getmaxx(WINDOW* win) { return getmaxx(win); }
int ncurses_clear() { return clear(); }
int ncurses_wattron(WINDOW* win, int attr) { return wattron(win, attr); }
int ncurses_wattroff(WINDOW* win, int attr) { return wattroff(win, attr); }
int ncurses_attron(int attr) { return attron(attr); }
int ncurses_attroff(int attr) { return attroff(attr); }

int ncurses_KEY_DOWN() { return KEY_DOWN; }
int ncurses_KEY_UP() { return KEY_UP; }
int ncurses_KEY_LEFT() { return KEY_LEFT; }
int ncurses_KEY_RIGHT() { return KEY_RIGHT; }
int ncurses_KEY_HOME() { return KEY_HOME; }
int ncurses_KEY_BACKSPACE() { return KEY_BACKSPACE; }
int ncurses_KEY_DC() { return KEY_DC; }

int ncurses_OK() { return OK; }
int ncurses_ERR() { return ERR; }

int ncurses_A_NORMAL() { return A_NORMAL; }
int ncurses_A_STANDOUT() { return A_STANDOUT; }
int ncurses_A_UNDERLINE() { return A_UNDERLINE; }
int ncurses_A_REVERSE() { return A_REVERSE; }
int ncurses_A_BLINK() { return A_BLINK; }
int ncurses_A_DIM() { return A_DIM; }
int ncurses_A_BOLD() { return A_BOLD; }
int ncurses_A_PROTECT() { return A_PROTECT; }
int ncurses_A_INVIS() { return A_INVIS; }
int ncurses_A_ALTCHARSET() { return A_ALTCHARSET; }
int ncurses_A_CHARTEXT() { return A_CHARTEXT; }
