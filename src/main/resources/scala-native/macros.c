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
int ncurses_mvaddnstr(int y, int x, char* str, int n) { return mvaddnstr(y, x, str, n); }
int ncurses_mvwaddnstr(WINDOW* win, int y, int x, char* str, int n) { return mvwaddnstr(win, y, x, str, n); }
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
void ncurses_bkgdset(chtype ch) { bkgdset(ch); }
void ncurses_bkgd(chtype ch) { bkgd(ch); }
void ncurses_getmaxyx(WINDOW* win, int* y, int* x) { getmaxyx(win, *y, *x); }
void ncurses_getyx(WINDOW* win, int* y, int* x) { getyx(win, *y, *x); }
int ncurses_getcury(WINDOW* win) { return getcury(win); }
int ncurses_getcurx(WINDOW* win) { return getcurx(win); }
int ncurses_scroll(WINDOW* win) { return scroll(win); }
int ncurses_mvwchgat(WINDOW *win, int y, int x, int n, attr_t attr, short pair, const void *opts) { return mvwchgat(win, y, x, n , attr, pair, opts); }
int ncurses_chgat(int n, attr_t attr, short pair, const void *opts) { return chgat( n, attr, pair, opts); }
int ncurses_mvchgat(int y, int x, int n, attr_t attr, short pair, const void *opts) { return mvchgat(y, x, n, attr, pair, opts); }
int ncurses_box(WINDOW *win, chtype verch, chtype horch) { return box(win, verch, horch); }
int ncurses_mvhline(int y, int x, chtype ch, int n) { return mvhline(y, x, ch, n); }
int ncurses_mvvline(int y, int x, chtype ch, int n) { return mvvline(y, x, ch, n); }
int ncurses_border(chtype ls, chtype rs, chtype ts, chtype bs, chtype tl, chtype tr, chtype bl, chtype br) { return border(ls, rs, ts, bs, tl, tr, bl, br); }
int ncurses_mvwhline(WINDOW *win, int y, int x, chtype ch, int n) { return mvwhline(win, y, x, ch, n); }
int ncurses_mvwvline(WINDOW *win, int y, int x, chtype ch, int n) { return mvwvline(win, y, x, ch, n); }
int ncurses_addchstr(const chtype *chstr) { return addchstr(chstr); }
int ncurses_addchnstr(const chtype *chstr, int n) { return addchnstr(chstr, n); }
int ncurses_waddchstr(WINDOW *win, const chtype *chstr) { return waddchstr(win, chstr); }
int ncurses_mvaddchstr(int y, int x, const chtype *chstr) { return mvaddchstr(y, x, chstr); }
int ncurses_mvaddchnstr(int y, int x, const chtype *chstr, int n) { return mvaddchnstr(y, x, chstr, n); }
int ncurses_mvwaddchstr(WINDOW *win, int y, int x, const chtype *chstr) { return mvwaddchstr(win, y, x, chstr); }
int ncurses_mvwaddchnstr(WINDOW *win, int y, int x, const chtype *chstr, int n) { return mvwaddchnstr(win, y, x, chstr, n); }

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
int ncurses_KEY_F1() { return KEY_F(1); }
int ncurses_KEY_F2() { return KEY_F(2); }
int ncurses_KEY_F3() { return KEY_F(3); }
int ncurses_KEY_F4() { return KEY_F(4); }
int ncurses_KEY_F5() { return KEY_F(5); }
int ncurses_KEY_F6() { return KEY_F(6); }
int ncurses_KEY_F7() { return KEY_F(7); }
int ncurses_KEY_F8() { return KEY_F(8); }
int ncurses_KEY_F9() { return KEY_F(9); }
int ncurses_KEY_F10() { return KEY_F(10); }
int ncurses_KEY_F11() { return KEY_F(11); }
int ncurses_KEY_F12() { return KEY_F(12); }
int ncurses_KEY_MOUSE() { return KEY_MOUSE; }

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

chtype ncurses_ACS_ULCORNER() { return ACS_ULCORNER; }
chtype ncurses_ACS_LLCORNER() { return ACS_LLCORNER; }
chtype ncurses_ACS_URCORNER() { return ACS_URCORNER; }
chtype ncurses_ACS_LRCORNER() { return ACS_LRCORNER; }
chtype ncurses_ACS_LTEE() { return ACS_LTEE; }
chtype ncurses_ACS_RTEE() { return ACS_RTEE; }
chtype ncurses_ACS_BTEE() { return ACS_BTEE; }
chtype ncurses_ACS_TTEE() { return ACS_TTEE; }
chtype ncurses_ACS_HLINE() { return ACS_HLINE; }
chtype ncurses_ACS_VLINE() { return ACS_VLINE; }
chtype ncurses_ACS_PLUS() { return ACS_PLUS; }
chtype ncurses_ACS_S1() { return ACS_S1; }
chtype ncurses_ACS_S9() { return ACS_S9; }
chtype ncurses_ACS_DIAMOND() { return ACS_DIAMOND; }
chtype ncurses_ACS_CKBOARD() { return ACS_CKBOARD; }
chtype ncurses_ACS_DEGREE() { return ACS_DEGREE; }
chtype ncurses_ACS_PLMINUS() { return ACS_PLMINUS; }
chtype ncurses_ACS_BULLET() { return ACS_BULLET; }
chtype ncurses_ACS_LARROW() { return ACS_LARROW; }
chtype ncurses_ACS_RARROW() { return ACS_RARROW; }
chtype ncurses_ACS_DARROW() { return ACS_DARROW; }
chtype ncurses_ACS_UARROW() { return ACS_UARROW; }
chtype ncurses_ACS_BOARD() { return ACS_BOARD; }
chtype ncurses_ACS_LANTERN() { return ACS_LANTERN; }
chtype ncurses_ACS_BLOCK() { return ACS_BLOCK; }
chtype ncurses_ACS_S3() { return ACS_S3; }
chtype ncurses_ACS_S7() { return ACS_S7; }
chtype ncurses_ACS_LEQUAL() { return ACS_LEQUAL; }
chtype ncurses_ACS_GEQUAL() { return ACS_GEQUAL; }
chtype ncurses_ACS_PI() { return ACS_PI; }
chtype ncurses_ACS_NEQUAL() { return ACS_NEQUAL; }
chtype ncurses_ACS_STERLING() { return ACS_STERLING; }
chtype ncurses_ACS_BSSB() { return ACS_BSSB; }
chtype ncurses_ACS_SSBB() { return ACS_SSBB; }
chtype ncurses_ACS_BBSS() { return ACS_BBSS; }
chtype ncurses_ACS_SBBS() { return ACS_SBBS; }
chtype ncurses_ACS_SBSS() { return ACS_SBSS; }
chtype ncurses_ACS_SSSB() { return ACS_SSSB; }
chtype ncurses_ACS_SSBS() { return ACS_SSBS; }
chtype ncurses_ACS_BSSS() { return ACS_BSSS; }
chtype ncurses_ACS_BSBS() { return ACS_BSBS; }
chtype ncurses_ACS_SBSB() { return ACS_SBSB; }
chtype ncurses_ACS_SSSS() { return ACS_SSSS; }

int ncurses_COLOR_PAIR(int n) { return COLOR_PAIR(n); }

mmask_t ncurses_ALL_MOUSE_EVENTS() { return ALL_MOUSE_EVENTS; }
mmask_t ncurses_BUTTON1_RELEASED() { return BUTTON1_RELEASED; }
mmask_t ncurses_BUTTON1_PRESSED() { return BUTTON1_PRESSED; }
mmask_t ncurses_BUTTON1_CLICKED() { return BUTTON1_CLICKED; }
mmask_t ncurses_BUTTON1_DOUBLE_CLICKED() { return BUTTON1_DOUBLE_CLICKED; }
mmask_t ncurses_BUTTON1_TRIPLE_CLICKED() { return BUTTON1_TRIPLE_CLICKED; }
mmask_t ncurses_BUTTON2_RELEASED() { return BUTTON2_RELEASED; }
mmask_t ncurses_BUTTON2_PRESSED() { return BUTTON2_PRESSED; }
mmask_t ncurses_BUTTON2_CLICKED() { return BUTTON2_CLICKED; }
mmask_t ncurses_BUTTON2_DOUBLE_CLICKED() { return BUTTON2_DOUBLE_CLICKED; }
mmask_t ncurses_BUTTON2_TRIPLE_CLICKED() { return BUTTON2_TRIPLE_CLICKED; }
mmask_t ncurses_BUTTON_CTRL() { return BUTTON_CTRL; }
mmask_t ncurses_BUTTON_SHIFT() { return BUTTON_SHIFT; }
mmask_t ncurses_BUTTON_ALT() { return BUTTON_ALT; }
mmask_t ncurses_REPORT_MOUSE_POSITION() { return REPORT_MOUSE_POSITION; }

int ncurses_COLOR_BLACK() { return COLOR_BLACK; }
int ncurses_COLOR_RED() { return COLOR_RED; }
int ncurses_COLOR_GREEN() { return COLOR_GREEN; }
int ncurses_COLOR_YELLOW() { return COLOR_YELLOW; }
int ncurses_COLOR_BLUE() { return COLOR_BLUE; }
int ncurses_COLOR_MAGENTA() { return COLOR_MAGENTA; }
int ncurses_COLOR_CYAN() { return COLOR_CYAN; }
int ncurses_COLOR_WHITE() { return COLOR_WHITE; }
