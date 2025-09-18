package net.encryptstar.spleaf.events;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerFireballShootListener implements Listener {
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private final int cooldownInMillis = 1000;
    private boolean onCooldown(UUID uuid) {
        if (cooldowns.get(uuid) == null) {
            cooldowns.put(uuid, System.currentTimeMillis());
            return false;
        }
        if (System.currentTimeMillis() - cooldowns.get(uuid) < cooldownInMillis) {
            return true;
        } else {
            cooldowns.put(uuid, System.currentTimeMillis());
            return false;
        }
    }

    @EventHandler
    public void rightClick(PlayerInteractEvent event) {
        // Player must right-click holding blaze rod to shoot fireball
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        ItemStack item = event.getItem();
        if (item == null || item.getType() != Material.BLAZE_ROD) return;
        if (onCooldown(event.getPlayer().getUniqueId())) {
            event.getPlayer().sendMessage("That action is on cooldown!");
            return;
        }

        // Fireball shoot logic
        Player player = event.getPlayer();
        Entity fireball = player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.SMALL_FIREBALL);
        fireball.setVelocity(player.getEyeLocation().getDirection());
        player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 10.0f, 1.0f);
    }
}
