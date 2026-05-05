package net.kblwbl.riftwalker.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RiftRipperItem extends SwordItem {
    public RiftRipperItem(ToolMaterials material, Settings settings) {
        super(material, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user.isSneaking()) {
            user.sendMessage(Text.literal("right click!!!!"));
        }

        return super.use(world, user, hand);
    }
}
