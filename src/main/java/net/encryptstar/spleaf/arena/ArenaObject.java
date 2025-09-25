package net.encryptstar.spleaf.arena;

import java.util.List;

import org.bukkit.Material;

public class ArenaObject {
    private class Coordinate {
        int x, y, z;
        Coordinate(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    private int minX, minY, minZ;
    private int maxX, maxY, maxZ;
    private Material leafType;
    private int yInc;
    private List<Coordinate> playerSpawns;
    
}
