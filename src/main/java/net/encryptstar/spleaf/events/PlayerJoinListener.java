package net.encryptstar.spleaf.events;

import java.util.logging.Level;

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
    public static final int MIN_PLAYERS = 2;

    private final Main plugin;
    public PlayerJoinListener(Main plugin) {
        this.plugin = plugin;
    }

    private static PreGameTimer timer = null;
    public static boolean isTimerStopped() {
        return (timer == null || timer.isCancelled());
    }
    public static void stopTimer() {
        if (!isTimerStopped()) {
            timer.cancel();
            timer = null;
        }
    }
    public static void startTimer(Main plugin) {
        if (isTimerStopped()) {
            timer = new PreGameTimer();
            timer.runTaskTimer(plugin, 1, 20);
        }
    }

    @EventHandler
    public void playerJoined(PlayerJoinEvent event) {
        pCount++;
        if (pCount >= MIN_PLAYERS) {
            startTimer(plugin);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    @EventHandler
    public void playerLeft(PlayerQuitEvent event) {
        pCount--;
        if (!isTimerStopped() && pCount < MIN_PLAYERS) {
            plugin.getServer().broadcastMessage("Countdown timer stopped! Not enough players!");
            plugin.getLogger().log(Level.INFO, "Game start was cancelled!");
            stopTimer();
        }
    }
}

