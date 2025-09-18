package net.encryptstar.spleaf.events;

import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.encryptstar.spleaf.Main;
import net.encryptstar.spleaf.timers.PreGameTimer;

public class PlayerJoinListener implements Listener {
    private static int pCount = 0;
    public static int getPlayerCount() {
        return pCount;
    }
    public static final int MIN_PLAYERS = 1;

    private final Main plugin;
    public PlayerJoinListener(Main plugin) {
        this.plugin = plugin;
    }

    private static PreGameTimer timer = null;
    public static boolean isTimerStopped() {
        return (timer == null || timer.isCancelled());
    }

    @EventHandler
    public void playerJoined(PlayerJoinEvent event) {
        pCount++;
        if (pCount >= MIN_PLAYERS) {
            if (isTimerStopped()) {
                timer = new PreGameTimer();
                timer.runTaskTimer(plugin, 1, 20);
            }
        }
    }

    @EventHandler
    public void playerLeft(PlayerQuitEvent event) {
        pCount--;
        if (!isTimerStopped() && pCount < MIN_PLAYERS) {
            for (Player p : plugin.getServer().getOnlinePlayers()) {
                p.sendMessage("Timer reset! Not enough players!");
                plugin.getLogger().log(Level.INFO, "Game start was cancelled!");
            }
            timer.cancel();
            timer = null;
        }
    }
}
