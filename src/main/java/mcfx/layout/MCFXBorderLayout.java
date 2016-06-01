package mcfx.layout;

import mcfx.component.AbstractMCFXComponent;
import mcfx.IMCFXConstants;
import mcfx.component.IMCFXContainer;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

public final class MCFXBorderLayout
implements IMCFXLayout{
  private final IMCFXContainer owner;
  private final Map<Byte, AbstractMCFXComponent> children = new HashMap<>();

  public MCFXBorderLayout(IMCFXContainer owner){
    this.owner = owner;
  }

  @Override
  public void add(AbstractMCFXComponent component, Object... flags) {
    byte flag = ((flags.length == 0) ? IMCFXConstants.CENTER : ((Byte) flags[0]));
    this.children.put(flag, component);
    this.owner.addComponent(component);
  }

  @Override
  public void add(AbstractMCFXComponent component) {

  }

  @Override
  public void layout() {
    int var4 = 0;
    int var5 = this.owner.size().height;
    int var6 = 0;
    int var7 = this.owner.size().width;

    AbstractMCFXComponent var9;
    Dimension var10;
    if((var9 = this.children.get(IMCFXConstants.TOP)) != null){
      var9.setSize(var7 - var6, var9.geometry().height);
      var10 = var9.preferredSize();
      var9.setGeometry(var6, var4, var7 - var6, var10.height);
      var4 += var10.height + 1;
    }

    if((var9 = this.children.get(IMCFXConstants.BOTTOM)) != null){
      var9.setSize(var7 - var6, var9.geometry().height);
      var10 = var9.preferredSize();
      var9.setGeometry(var6, var5 - var10.height, var7 - var6, var10.height);
      var5 -= var10.height + 1;
    }

    if((var9 = this.children.get(IMCFXConstants.RIGHT)) != null){
      var9.setSize(var9.geometry().width, var5 - var4);
      var10 = var9.preferredSize();
      var9.setGeometry(var7 - var10.width, var4, var10.width, var5 - var4);
      var7 -= var10.width + 1;
    }

    if((var9 = this.children.get(IMCFXConstants.LEFT)) != null){
      var9.setSize(var9.geometry().width, var5 - var4);
      var10 = var9.preferredSize();
      var9.setGeometry(var6, var4, var10.width, var5 - var4);
      var6 += var10.width + 1;
    }

    if((var9 = this.children.get(IMCFXConstants.CENTER)) != null){
      var9.setGeometry(var6, var4, var7 - var6, var5 - var4);
    }
  }
}