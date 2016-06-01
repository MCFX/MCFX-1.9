package mcfx.layout;

import mcfx.component.AbstractMCFXComponent;
import mcfx.component.IMCFXContainer;

public final class MCFXAbsoluteLayout
implements IMCFXLayout{
  private final IMCFXContainer owner;

  public MCFXAbsoluteLayout(IMCFXContainer owner){
    this.owner = owner;
  }

  @Override
  public void add(AbstractMCFXComponent component, Object... flags) {
    this.owner.addComponent(component);
  }

  @Override
  public void add(AbstractMCFXComponent component) {
    this.owner.addComponent(component);
  }

  @Override public void layout() {}
}