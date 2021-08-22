package xyz.hyperreal.ncurses

import xyz.hyperreal.ncurses.{LibNcurses => nc}
import nc.PANEL

class Panel private[ncurses] (val panel: PANEL) extends AnyVal {

  def panel_above: Panel = new Panel(nc.panel_above(panel))

}
