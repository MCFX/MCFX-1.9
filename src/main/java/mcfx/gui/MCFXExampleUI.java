package mcfx.gui;

import mcfx.IMCFXConstants;
import mcfx.component.MCFXButton;
import mcfx.component.MCFXFrame;
import mcfx.layout.MCFXBorderLayout;

import java.awt.Color;

public final class MCFXExampleUI
extends MCFXFrame{
  public MCFXExampleUI(){
    this.setBackground(Color.CYAN);
    this.setLayout(new MCFXBorderLayout(this));
    this.add(new MCFXButton("Top"), IMCFXConstants.TOP);
    this.add(new MCFXButton("Center"), IMCFXConstants.CENTER);
    this.add(new MCFXButton("Left"), IMCFXConstants.LEFT);
    this.add(new MCFXButton("Right"), IMCFXConstants.RIGHT);
    this.add(new MCFXButton("Bottom"), IMCFXConstants.BOTTOM);
  }
}