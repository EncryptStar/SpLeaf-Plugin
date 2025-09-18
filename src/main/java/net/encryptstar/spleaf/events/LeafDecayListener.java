package net.encryptstar.spleaf.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class LeafDecayListener implements Listener {
    @EventHandler
    public void onDecay(LeavesDecayEvent event) {
        // TODO: Add condition for some leaves to decay based on y-level
        event.setCancelled(true);
    }
}
