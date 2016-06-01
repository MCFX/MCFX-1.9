package mcfx.component;

import mcfx.component.model.button.AbstractMCFXButtonModel;

import java.awt.Color;

public abstract class AbstractMCFXButton
extends AbstractMCFXComponent{
  protected final AbstractMCFXButtonModel model;
  protected Color foreground = Color.WHITE;
  protected Color background = Color.BLACK;

  protected AbstractMCFXButton(AbstractMCFXButtonModel model){
    this.model = model;
  }

  public final void setBackground(Color c){
    this.background = c;
  }

  public final void setForeground(Color c){
    this.foreground = c;
  }

  public final AbstractMCFXButtonModel model(){
    return this.model;
  }
}