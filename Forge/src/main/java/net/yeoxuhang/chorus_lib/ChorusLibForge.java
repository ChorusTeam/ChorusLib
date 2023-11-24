package net.yeoxuhang.chorus_lib;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChorusLib.MOD_ID)
public class ChorusLibForge {
    public ChorusLibForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        ChorusLib.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ChorusLib.setBlockstateIsReplacements();
    }
}