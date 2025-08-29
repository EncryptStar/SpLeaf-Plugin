package net.encryptstar.spleaf.timers;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PreGameTimer extends BukkitRunnable {
    private final int TIMER_START = 60;
    private int timer = TIMER_START;

    @Override
    public void run() {
        if (Bukkit.getServer().getOnlinePlayers().size() >= 2) {
            // Update display timer (scoreboard, bossbar, etc)
            timer--;
        } else if (timer < TIMER_START) {
            // Notify players that timer reset
            timer = TIMER_START;
        }

        if (timer == 0) {
            // Teleport players, start game progression timer, and cancel this task
            this.cancel();
        }
    }
}
