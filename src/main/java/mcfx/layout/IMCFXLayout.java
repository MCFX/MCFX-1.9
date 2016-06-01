package mcfx.layout;

import mcfx.component.AbstractMCFXComponent;

public interface IMCFXLayout{
  public void add(AbstractMCFXComponent component, Object... flags);
  public void add(AbstractMCFXComponent component);
  public void layout();
}