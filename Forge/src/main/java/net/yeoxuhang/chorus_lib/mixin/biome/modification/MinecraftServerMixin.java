package net.yeoxuhang.chorus_lib.mixin.biome.modification;

import net.minecraft.core.RegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.PrimaryLevelData;
import net.minecraft.world.level.storage.WorldData;
import net.yeoxuhang.chorus_lib.impl.biome.modification.BiomeModificationImpl;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @Shadow @Final protected WorldData worldData;


    @Shadow public abstract RegistryAccess.Frozen registryAccess();

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void finalizeWorldGen(CallbackInfo ci) {
        if (!(worldData instanceof PrimaryLevelData levelProperties)) {
            throw new RuntimeException("Incompatible SaveProperties passed to MinecraftServer: " + this.worldData);
        }
        BiomeModificationImpl.INSTANCE.finalizeWorldGen(this.registryAccess(), levelProperties);
    }
}
