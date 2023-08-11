package net.yeoxuhang.chorus_lib;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yeoxuhang.chorus_lib.api.biome.CaveBiomes;


@Mod(ChorusLib.MOD_ID)
public class ChorusLibForge {
    public ChorusLibForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ChorusLib.init();
    }
}