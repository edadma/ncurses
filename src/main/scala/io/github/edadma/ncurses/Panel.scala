package io.github.edadma.ncurses

import io.github.edadma.ncurses.extern.{LibNcurses => nc}

class Panel private[ncurses] (private[ncurses] val pan: nc.PANEL) extends AnyVal {

  def panel_above: Panel = new Panel(nc.panel_above(pan))

  def panel_below: Panel = new Panel(nc.panel_below(pan))

  def show_panel: Int = nc.show_panel(pan)

  def hide_panel: Int = nc.hide_panel(pan)

  def top_panel: Int = nc.top_panel(pan)

  def bottom_panel: Int = nc.bottom_panel(pan)

  def del_panel: Int = nc.del_panel(pan)

  def panel_window: Window = new Window(nc.panel_window(pan))

  def replace_panel(win: Window): Int = nc.replace_panel(pan, win.win)

  def move_panel(starty: Int, startx: Int): Int = nc.move_panel(pan, starty, startx)

  def panel_hidden: Boolean = nc.panel_hidden(pan)

  def set_panel_userptr(ptr: Panel): Int = nc.set_panel_userptr(pan, ptr.pan)

  def panel_userptr: Panel = new Panel(nc.panel_userptr(pan))

}
