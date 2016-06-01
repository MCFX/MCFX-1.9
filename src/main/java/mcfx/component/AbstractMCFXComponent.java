package mcfx.component;

import mcfx.MCFXTessellator;

import java.awt.Dimension;
import java.awt.Rectangle;

public abstract class AbstractMCFXComponent{
  protected Rectangle bounds = new Rectangle();
  protected Dimension preferredSize = new Dimension(128, 16);
  protected AbstractMCFXComponent parent;
  protected float zLevel = 1.0F;

  protected AbstractMCFXComponent(){
    this.bounds.setBounds(0, 0, 128, 16);
  }

  public final void setGeometry(int x, int y, int width, int height){
    this.bounds.setBounds(x, y, width, height);
  }

  public final void setSize(int width, int height){
    this.bounds.setSize(width, height);
  }

  public final void setPosition(int x, int y){
    this.bounds.setLocation(x, y);
  }

  public final void setZLevel(float zLevel){
    this.zLevel = zLevel;
  }

  public final Rectangle geometry(){
    return this.bounds;
  }

  public final Dimension preferredSize(){
    return this.preferredSize;
  }

  public final int getX(){
    return this.bounds.x;
  }

  public final int getY(){
    return this.bounds.y;
  }

  public final float getZLevel(){
    return this.zLevel;
  }

  public abstract void render(MCFXTessellator tess);
}