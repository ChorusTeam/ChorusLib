package net.yeoxuhang.chorus_lib;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;

public class ChorusLibFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ChorusLib.init();
        ChorusLib.setBlockstateIsReplacements();
    }
}
