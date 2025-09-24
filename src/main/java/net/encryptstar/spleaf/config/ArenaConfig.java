package net.encryptstar.spleaf.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class ArenaConfig {
    private static File file;
    private static FileConfiguration config;

    public static void setup() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Spleaf");
        assert (plugin != null);
        if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
        file = new File(plugin.getDataFolder(), "arenaconfig.yml");

        try {
            if (file.createNewFile()) {
                plugin.getLogger().log(Level.INFO, "Arena config file not found. Created new file.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return config;
    }
}
