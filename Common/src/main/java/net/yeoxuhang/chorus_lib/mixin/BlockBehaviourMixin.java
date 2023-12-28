package net.yeoxuhang.chorus_lib.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.yeoxuhang.chorus_lib.ChorusLib;
import net.yeoxuhang.chorus_lib.common.block.Nylium;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockBehaviourMixin {

    @Inject(at = @At("HEAD"), method = "is(Lnet/minecraft/world/level/block/Block;)Z", cancellable = true)
    private void useIsReplacement(Block block, CallbackInfoReturnable<Boolean> info) {
        var replacements = ChorusLib.getBlockstateIsReplacements();
        if (replacements.containsKey(block) && replacements.get(block).test(asThis())) {
            info.setReturnValue(true);
        }
    }

    private BlockBehaviour.BlockStateBase asThis() {
        return (BlockBehaviour.BlockStateBase) (Object) this;
    }
}
