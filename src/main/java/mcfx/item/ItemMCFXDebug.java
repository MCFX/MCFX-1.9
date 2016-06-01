package mcfx.item;

import mcfx.MCFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public final class ItemMCFXDebug
extends Item {
  @Override
  public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
    playerIn.openGui(MCFX.instance, 0x0, worldIn, ((int) playerIn.posX), ((int) playerIn.posY), ((int) playerIn.posZ));
    return ActionResult.newResult(EnumActionResult.PASS, itemStackIn);
  }
}
