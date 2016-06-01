package mcfx.component;

import mcfx.MCFXTessellator;
import mcfx.component.model.button.MCFXButtonModel;

import java.awt.Color;

public class MCFXButton
extends AbstractMCFXButton {
  protected final String label;

  public MCFXButton(String label) {
    super(new MCFXButtonModel());
    this.label = label;
  }

  private Color complement(Color c) {
    return new Color(
                    255 - c.getRed(),
                    255 - c.getGreen(),
                    255 - c.getBlue(),
                    c.getAlpha()
    );
  }

  @Override
  public void render(MCFXTessellator tess) {
    tess.setZLevel(this.zLevel)
        .setColor((this.model.isClicked() ? this.complement(this.background) : this.background))
        .drawRectangle(this.bounds);
    int lX = ((this.bounds.width - tess.stringWidth(this.label)) / 2);
    int lY = ((this.bounds.height - tess.stringHeight()) / 2);
    tess.setColor((this.model.isClicked() ? this.complement(this.foreground) : this.foreground))
        .drawString(this.label, this.getX() + lX, this.getY() + lY);
  }
}