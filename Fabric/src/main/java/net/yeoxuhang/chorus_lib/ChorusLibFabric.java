package net.yeoxuhang.chorus_lib;

import net.fabricmc.api.ModInitializer;

public class ChorusLibFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ChorusLib.init();
    }
}
