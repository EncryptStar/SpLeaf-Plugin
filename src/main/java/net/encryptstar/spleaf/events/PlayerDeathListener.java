package net.encryptstar.spleaf.events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.encryptstar.spleaf.GameEnd;
import net.encryptstar.spleaf.GameStart;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        GameStart.playersAlive--;
        event.getEntity().getInventory().clear();
        event.getEntity().setGameMode(GameMode.SPECTATOR);
        if (GameStart.playersAlive <= 1) {
            GameEnd.resetGame();
        }
    }
}
