package net.encryptstar.spleaf.events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (event.getPlayer().getGameMode() == GameMode.ADVENTURE) {
            event.setCancelled(true);
        }
    }
}
