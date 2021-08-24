package xyz.hyperreal.ncurses.facade

import xyz.hyperreal.ncurses.extern.{LibNcurses => nc}

class Panel private[facade] (private[facade] val panel: nc.PANEL) extends AnyVal {

  def panel_above: Panel = new Panel(nc.panel_above(panel))

}
