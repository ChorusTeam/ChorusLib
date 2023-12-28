package net.yeoxuhang.chorus_lib.api.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.electronwill.nightconfig.toml.TomlWriter;
import com.google.common.io.Files;
import net.yeoxuhang.chorus_lib.ChorusLib;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ConfigFile extends Config {
    private final Path config;
    public final File dir;

    public ConfigFile(Path configFile, Path directory) {
        super(CommentedFileConfig.builder(configFile).sync().autosave().build());
        dir = new File(directory.toString());
        if (!dir.exists()){
            boolean mkdir = dir.mkdir();
            ChorusLib.logInfo("Created " + configFile.getFileName() + " configuration directory");
        }
        this.config = configFile;

        ((CommentedFileConfig)this.getConfig()).load();
    }

    public void save() {
        (new TomlWriter()).write(sortConfig(this.getConfig()), config.toFile(), WritingMode.REPLACE);
    }
}
