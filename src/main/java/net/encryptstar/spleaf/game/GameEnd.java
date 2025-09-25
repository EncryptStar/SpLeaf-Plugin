package net.encryptstar.spleaf.game;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GameEnd {
    public static void resetGame() {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.teleport(new Location(p.getWorld(), 0, -60, 0));
            p.setGameMode(GameMode.ADVENTURE);
        }
    }
}
