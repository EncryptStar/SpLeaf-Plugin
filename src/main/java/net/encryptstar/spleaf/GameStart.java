package net.encryptstar.spleaf;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class GameStart {
    public static int playersAlive = 0;

    private static void buildFloors(int x1, int y1, int z1, int x2, int y2, int z2, int yInc) {
        int minX = Math.min(x1, x2), maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2), maxY = Math.max(y1, y2);
        int minZ = Math.min(z1, z2), maxZ = Math.max(z1, z2);

        World world = Bukkit.getWorld("world");
        assert (world != null);
        for (int y=minY; y<=maxY; y+=yInc) {
            for (int x=minX; x<=maxX; x++) {
                for (int z=minZ; z<=maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    block.setType(Material.OAK_LEAVES);
                }
            }
        }
    }

    public static void teleportPlayers() {
        playersAlive = 0;
        buildFloors(-20, -55, 34, -40, -31, 14, 6);
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            playersAlive++;
            p.teleport(new Location(p.getWorld(), -30, -30, 24));
            p.setGameMode(GameMode.ADVENTURE);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give "+p.getName()+" shears[can_break=[{blocks:\"oak_leaves\"},{blocks:\"fire\"}],unbreakable={}] 1");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give "+p.getName()+" blaze_rod 1");
        }
    }
}
