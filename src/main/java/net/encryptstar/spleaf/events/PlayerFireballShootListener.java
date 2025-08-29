package net.encryptstar.spleaf.events;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerFireballShootListener implements Listener {
    // TODO: Add a cooldown and use the in-game indicator

    @EventHandler
    public void rightClick(PlayerInteractEvent event) {
        // Player must right-click holding blaze rod to shoot fireball
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        ItemStack item = event.getItem();
        if (item == null || item.getType() != Material.BLAZE_ROD) return;

        // Fireball shoot logic
        Player player = event.getPlayer();
        Entity fireball = player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.SMALL_FIREBALL);
        fireball.setVelocity(player.getEyeLocation().getDirection());
    }
}
