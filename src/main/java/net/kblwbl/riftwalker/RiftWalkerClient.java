package net.kblwbl.riftwalker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.kblwbl.riftwalker.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class RiftWalkerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RiftWalker.LOGGER.info("THE RIFTWALKER IS ALIIIVEEE!!!!");
        for (Block block : ModBlocks.BLOCK_CUTOUT) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }
    }
}