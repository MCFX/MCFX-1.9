package mcfx.component;

import java.awt.Dimension;

public interface IMCFXContainer{
  public void add(AbstractMCFXComponent component);
  public void add(AbstractMCFXComponent component, Object... flags);
  public void addComponent(AbstractMCFXComponent component);
  public void layout();
  public void render();
  public Dimension size();
}