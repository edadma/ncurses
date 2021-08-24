package xyz.hyperreal.ncurses.facade

import xyz.hyperreal.ncurses.extern.{LibNcurses => nc}

class Panel private[facade] (private[facade] val panel: nc.PANEL) extends AnyVal {

  def panel_above: Panel = new Panel(nc.panel_above(panel))

  def panel_below: Panel = new Panel(nc.panel_below(panel))

  def show_panel: Int = nc.show_panel(panel)

  def hide_panel: Int = nc.hide_panel(panel)

  def top_panel: Int = nc.top_panel(panel)

  def bottom_panel: Int = nc.bottom_panel(panel)

  def del_panel: Int = nc.del_panel(panel)

}
