package mcfx.component;

import mcfx.MCFXTessellator;
import mcfx.layout.IMCFXLayout;
import mcfx.layout.MCFXAbsoluteLayout;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.FMLClientHandler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public abstract class MCFXFrame
extends GuiScreen
implements IMCFXContainer {
  private final List<AbstractMCFXComponent> children = new LinkedList<>();
  private final Rectangle bounds = new Rectangle();
  private final Insets insets = new Insets(4, 4, 4, 4);
  private final int xSize;
  private final int ySize;
  private Color background = Color.BLACK;
  private IMCFXLayout layout = new MCFXAbsoluteLayout(this);

  protected MCFXFrame() {
    this(FMLClientHandler.instance()
                         .getClient().displayWidth / 4, FMLClientHandler.instance()
                                                                        .getClient().displayHeight / 4);
  }

  protected MCFXFrame(int xSize, int ySize) {
    this.xSize = xSize;
    this.ySize = ySize;
  }

  @Override
  public void initGui() {
    super.initGui();
    int guiLeft = ((this.width - this.xSize) / 2);
    int guiTop = ((this.height - this.ySize) / 2);
    this.bounds.setBounds(guiLeft, guiTop, this.xSize, this.ySize);
    this.layout();
    this.bounds.setBounds(this.bounds.x, this.bounds.y, this.bounds.width + (this.insets.right * 2), this.bounds.height + (this.insets.bottom * 2));
  }

  @Override
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    super.drawScreen(mouseX, mouseY, partialTicks);
    this.render();
  }

  @Override
  public void layout() {
    this.layout.layout();
    for (AbstractMCFXComponent component : this.children) {
      component.setPosition(this.bounds.x + this.insets.left + component.getX(), this.bounds.y + this.insets.top + component.getY());
      if (component instanceof IMCFXContainer) {
        ((IMCFXContainer) component).layout();
      }
    }
  }

  @Override
  public void add(AbstractMCFXComponent component) {
    this.layout.add(component);
  }

  @Override
  public void add(AbstractMCFXComponent component, Object... flags) {
    this.layout.add(component, flags);
  }

  @Override
  public void addComponent(AbstractMCFXComponent component) {
    component.setZLevel(this.zLevel + 1.0F);
    this.children.add(component);
  }

  @Override
  public void render() {
    MCFXTessellator tess = MCFXTessellator.instance()
                                          .setColor(this.background)
                                          .drawRectangle(this.bounds);
    for (AbstractMCFXComponent component : this.children) {
      component.render(tess.reset());
    }
  }

  @Override
  public Dimension size() {
    return this.bounds.getSize();
  }

  public void setLayout(IMCFXLayout layout) {
    this.layout = layout;
  }

  public void setInsets(int top, int left, int bottom, int right){
    this.insets.set(top, left, bottom, right);
  }

  public void setBackground(Color c){
    this.background = c;
  }
}