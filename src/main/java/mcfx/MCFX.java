package mcfx;

import mcfx.gui.MCFXExampleUI;
import mcfx.item.ItemMCFXDebug;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
modid = "mcfx",
name = "MinecraftFX",
version = "0.0.0.0"
)
public final class MCFX
implements IGuiHandler {
  @Mod.Instance("mcfx")
  public static MCFX instance;

  public static final Item itemDebug = new ItemMCFXDebug()
                                       .setCreativeTab(CreativeTabs.tabMisc)
                                       .setUnlocalizedName("debug");

  @Mod.EventHandler
  public void onInit(FMLInitializationEvent e) {
    NetworkRegistry.INSTANCE.registerGuiHandler(instance, instance);

    GameRegistry.register(itemDebug, new ResourceLocation("mcfx", "debug"));
  }

  @Override
  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    return null;
  }

  @Override
  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    switch (ID) {
      case 0:
        return new MCFXExampleUI();
      default:
        return null;
    }
  }
}