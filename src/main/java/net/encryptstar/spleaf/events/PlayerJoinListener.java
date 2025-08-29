package net.encryptstar.spleaf.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinListener implements Listener {
    private static int pCount = 0;

    @EventHandler
    public void playerJoined(PlayerJoinEvent event) {
        pCount++;
    }

    @EventHandler
    public void playerLeft(PlayerQuitEvent event) {
        pCount--;
    }
}
