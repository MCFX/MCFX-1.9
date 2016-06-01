package mcfx;

import mcfx.component.AbstractMCFXComponent;

public interface IMCFXDecorator<TComponent extends AbstractMCFXComponent>{
  public void initialize(TComponent component);
  public void render(TComponent component);
}