package net.encryptstar.spleaf;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import net.encryptstar.spleaf.events.LeafDecayListener;
import net.encryptstar.spleaf.events.PlayerDeathListener;
import net.encryptstar.spleaf.events.PlayerDropItemListener;
import net.encryptstar.spleaf.events.PlayerFireballShootListener;
import net.encryptstar.spleaf.events.PlayerJoinListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, "The SpLeaf plugin loaded successfully!");
        getServer().getPluginManager().registerEvents(new LeafDecayListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerFireballShootListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
