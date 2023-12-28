package net.yeoxuhang.chorus_lib.config;
import net.yeoxuhang.chorus_lib.api.config.Config;
import net.yeoxuhang.chorus_lib.api.config.ConfigFile;

import java.nio.file.Path;

public class ChorusLibConfig extends ConfigFile {
    public final boolean shouldEnableSurfaceRules;

    public ChorusLibConfig(Path configFile, Path directory) {
        super(configFile, directory);
        Config generationSettings = this.getSubConfig("surface_rule_settings");
        this.shouldEnableSurfaceRules = generationSettings.add("Should enable surface rule", "enable_surface_rule", true);
        this.addSubConfig("Generation settings", "generation_settings", generationSettings);
        this.save();
    }
}
