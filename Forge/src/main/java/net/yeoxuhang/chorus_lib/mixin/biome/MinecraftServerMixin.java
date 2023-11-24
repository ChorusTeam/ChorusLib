package net.yeoxuhang.chorus_lib.mixin.biome;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow
    public abstract WorldData getWorldData();
    @Inject(method = "createLevels", at = @At("RETURN"))
    private void chorusLibCreateLevels(ChunkProgressListener $$0, CallbackInfo ci) {
    }

}
