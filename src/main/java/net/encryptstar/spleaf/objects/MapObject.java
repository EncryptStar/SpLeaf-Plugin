package net.encryptstar.spleaf.objects;

import java.util.List;

import org.bukkit.util.BlockVector;

public class MapObject {
    final BlockVector pivot; // Most positive point in selection
    final BlockVector size;
    final List<BlockVector> playerSpawns;
    final List<BlockVector> floors; // Most positive point in each floor

    public MapObject(BlockVector pivot, BlockVector size, List<BlockVector> playerSpawns, List<BlockVector> floors) {
        this.pivot = pivot;
        this.size = size;
        this.playerSpawns = playerSpawns;
        this.floors = floors;
    }
}
