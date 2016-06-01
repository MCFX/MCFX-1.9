package mcfx.component.model.button;

public abstract class AbstractMCFXButtonModel{
  protected boolean clicked;
  protected boolean active;

  public final boolean isClicked(){
    return this.clicked;
  }

  public final boolean isActive(){
    return this.active;
  }

  public final void setClicked(boolean clicked){
    this.clicked = clicked;
  }

  public final void setActive(boolean active){
    this.active = active;
  }
}