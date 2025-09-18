package net.encryptstar.spleaf.timers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.encryptstar.spleaf.GameStart;
import net.encryptstar.spleaf.events.PlayerJoinListener;

public class PreGameTimer extends BukkitRunnable {
    private final int TIMER_START = 60;
    private int timer = TIMER_START;

    @Override
    public void run() {
        if (PlayerJoinListener.getPlayerCount() >= PlayerJoinListener.MIN_PLAYERS) {
            // Update display timer (scoreboard, bossbar, etc)
            timer--;
            if (timer % 10 == 0 || timer < 10) {
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.sendMessage("Game starts in "+ timer + " seconds!");
                }
            }
        }

        if (timer == 0) {
            // Teleport players, start game progression timer, and cancel this task
            GameStart.teleportPlayers();
            this.cancel();
        }
    }
}
