#include <ncurses.h>

int ncurses_refresh() { return refresh(); }
int ncurses_getch() { return getch(); }
int ncurses_scrl(int n) { return scrl(n); }
int ncurses_move(int y, int x) { return move(y, x); }
int ncurses_addstr(char* str) { return addstr(str); }
int ncurses_addnstr(char* str, int n) { return addnstr(str, n); }
int ncurses_mvaddstr(int y, int x, char* str) { return mvaddstr(y, x, str); }
int ncurses_waddstr(WINDOW* win, char* str) { return waddstr(win, str); }
int ncurses_mvwaddstr(WINDOW* win, int y, int x, char* str) { return mvwaddstr(win, y, x, str); }
int ncurses_addch(chtype ch) { return addch(ch); }
int ncurses_clrtoeol() { return clrtoeol(); }
int ncurses_clrtobot() { return clrtobot(); }
int ncurses_getmaxy(WINDOW* win) { return getmaxy(win); }
int ncurses_getmaxx(WINDOW* win) { return getmaxx(win); }
int ncurses_clear() { return clear(); }
int ncurses_wattron(WINDOW* win, int attr) { return wattron(win, attr); }
int ncurses_wattroff(WINDOW* win, int attr) { return wattroff(win, attr); }
int ncurses_attron(int attr) { return attron(attr); }
int ncurses_attroff(int attr) { return attroff(attr); }
void ncurses_bkgdset(chtype ch) { return bkgdset(ch); }
void ncurses_getmaxyx(WINDOW* win, int* y, int* x) { getmaxyx(win, *y, *x); }
void ncurses_getyx(WINDOW* win, int* y, int* x) { getyx(win, *y, *x); }
int ncurses_getcury(WINDOW* win) { return getcury(win); }
int ncurses_getcurx(WINDOW* win) { return getcurx(win); }
int ncurses_mvwchgat(WINDOW *win, int y, int x, int n, attr_t attr, short pair, const void *opts) { return mvwchgat(win, y, x, n , attr, pair, opts); }
             // todo: add mvwchgat, chgat
int ncurses_chgat(int n, attr_t attr, short pair, const void *opts) { return chgat( n, attr, pair, opts); }
int ncurses_mvchgat(int y, int x, int n, attr_t attr, short pair, const void *opts) { return mvchgat(y, x, attr, pair, opts); }

int ncurses_KEY_DOWN() { return KEY_DOWN; }
int ncurses_KEY_UP() { return KEY_UP; }
int ncurses_KEY_LEFT() { return KEY_LEFT; }
int ncurses_KEY_RIGHT() { return KEY_RIGHT; }
int ncurses_KEY_HOME() { return KEY_HOME; }
int ncurses_KEY_END() { return KEY_END; }
int ncurses_KEY_BACKSPACE() { return KEY_BACKSPACE; }
int ncurses_KEY_DC() { return KEY_DC; }
int ncurses_KEY_PPAGE() { return KEY_PPAGE; }
int ncurses_KEY_NPAGE() { return KEY_NPAGE; }
int ncurses_KEY_IC() { return KEY_IC; }
int ncurses_KEY_STAB() { return KEY_STAB; }

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

chtype ncurses_ACS_VLINE() { return ACS_VLINE; }

int ncurses_COLOR_PAIR(int n) { return COLOR_PAIR(n); }
