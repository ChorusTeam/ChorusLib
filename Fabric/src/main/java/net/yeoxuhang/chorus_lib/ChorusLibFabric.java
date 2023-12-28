package net.yeoxuhang.chorus_lib;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.yeoxuhang.chorus_lib.config.ChorusLibConfig;

import java.nio.file.Path;

import static net.yeoxuhang.chorus_lib.ChorusLib.*;

public class ChorusLibFabric implements ModInitializer {
    private static final Path path = FabricLoader.getInstance().getConfigDir();
    private static final ChorusLibConfig CONFIGS = new ChorusLibConfig(path.resolve(MOD_ID +"/config.toml"), path.resolve(MOD_ID));
    @Override
    public void onInitialize() {
        init();
        setConfig(CONFIGS);
        setBlockstateIsReplacements();
    }
}
