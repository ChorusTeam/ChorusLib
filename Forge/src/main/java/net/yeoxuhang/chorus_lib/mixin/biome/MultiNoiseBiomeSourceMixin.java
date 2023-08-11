package net.yeoxuhang.chorus_lib.mixin.biome;

import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.yeoxuhang.chorus_lib.impl.biome.BiomeSourceAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MultiNoiseBiomeSource.class)
public class MultiNoiseBiomeSourceMixin implements BiomeSourceAccess {
    @Unique
    private boolean modifyBiomeEntries = true;

    @Override
    public void setModifyBiomeEntries(boolean modifyBiomeEntries) {
        this.modifyBiomeEntries = modifyBiomeEntries;
    }

    @Override
    public boolean shouldModifyBiomeEntries() {
        return this.modifyBiomeEntries;
    }
}
