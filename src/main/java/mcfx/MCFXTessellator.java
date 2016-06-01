package mcfx;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import org.lwjgl.opengl.GL11;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public final class MCFXTessellator
extends Tessellator {
  private static final Point ORIGIN = new Point(0, 0);
  private static MCFXTessellator instance = null;
  private Color currentColor = Color.BLACK;
  private Point currentPos = ORIGIN;
  private float zLevel = 0.0F;
  private float alpha = 1.0F;

  private MCFXTessellator() {
    super(0x200000);
  }

  public static MCFXTessellator instance() {
    return (instance == null
            ? (instance = new MCFXTessellator())
            : instance);
  }

  private float getColorRed() {
    return this.currentColor.getRed() / 255;
  }

  private float getColorGreen() {
    return this.currentColor.getGreen() / 255;
  }

  private float getColorBlue() {
    return this.currentColor.getBlue() / 255;
  }

  private float getX() {
    return this.currentPos.x;
  }

  private float getY() {
    return this.currentPos.y;
  }

  public MCFXTessellator drawRectangle(Rectangle geom) {
    GlStateManager.disableTexture2D();
    VertexBuffer vb = this.getBuffer();
    vb.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
    vb.pos(this.getX() + geom.x, this.getY() + geom.y + geom.height, this.zLevel)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    vb.pos(this.getX() + geom.x + geom.width, this.getY() + geom.y + geom.height, this.zLevel)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    vb.pos(this.getX() + geom.x + geom.width, this.getY() + geom.y, this.zLevel)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    vb.pos(this.getX() + geom.x, this.getY() + geom.y, this.zLevel)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    this.draw();
    GlStateManager.enableTexture2D();
    return this;
  }

  public MCFXTessellator drawImage(ResourceLocation image, Rectangle geom){
    VertexBuffer vb = this.getBuffer();
    vb.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
    vb.pos(this.getX() + geom.x, this.getY() + geom.y + geom.height, this.zLevel)
      .tex(0, 1)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    vb.pos(this.getX() + geom.x + geom.width, this.getY() + geom.y + geom.height, this.zLevel)
      .tex(1, 1)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    vb.pos(this.getX() + geom.x + geom.width, this.getY() + geom.y, this.zLevel)
      .tex(1, 0)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    vb.pos(this.getX() + geom.x, this.getY() + geom.y, this.zLevel)
      .tex(0, 0)
      .color(this.getColorRed(), this.getColorGreen(), this.getColorBlue(), this.alpha)
      .endVertex();
    this.draw();
    return this;
  }

  public MCFXTessellator drawString(String text, int x, int y){
    FontRenderer font = FMLClientHandler.instance().getClient().fontRendererObj;
    GlStateManager.pushMatrix();
    GlStateManager.translate(0.0F, 0.0F, this.zLevel + 1);
    font.drawString(text, ((int) this.getX() + x), ((int) this.getY() + y), this.currentColor.getRGB());
    GlStateManager.popMatrix();
    return this;
  }

  public MCFXTessellator drawString(String text){
    return this.drawString(text, 0, 0);
  }

  public int stringWidth(String text){
    FontRenderer font = FMLClientHandler.instance().getClient().fontRendererObj;
    return font.getStringWidth(text);
  }

  public int stringHeight(){
    return FMLClientHandler.instance().getClient().fontRendererObj.FONT_HEIGHT;
  }

  public MCFXTessellator translate(int x, int y){
    this.currentPos.translate(x, y);
    return this;
  }

  public MCFXTessellator reset(){
    this.currentColor = Color.BLACK;
    this.currentPos = ORIGIN;
    this.alpha = 1.0F;
    this.zLevel = 0.0F;
    return this;
  }

  public MCFXTessellator setAlpha(float alpha){
    this.alpha = alpha;
    return this;
  }

  public MCFXTessellator setColor(Color c){
    this.currentColor = c;
    return this;
  }

  public MCFXTessellator setZLevel(float zLevel){
    this.zLevel = zLevel;
    return this;
  }
}