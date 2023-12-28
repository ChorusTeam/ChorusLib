package net.yeoxuhang.chorus_lib;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.yeoxuhang.chorus_lib.api.config.ConfigFile;
import net.yeoxuhang.chorus_lib.config.ChorusLibConfig;

import java.nio.file.Path;

import static net.yeoxuhang.chorus_lib.ChorusLib.*;


@Mod(MOD_ID)
public class ChorusLibForge {
    private static final Path path = FMLPaths.CONFIGDIR.get();
    private static final ChorusLibConfig CONFIGS = new ChorusLibConfig(path.resolve(MOD_ID + "/general.toml"), path.resolve(MOD_ID));

    public ChorusLibForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        setConfig(CONFIGS);
        init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        setBlockstateIsReplacements();
    }
}