package us.artit.sbprisoncore.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.BOLD;
import static org.bukkit.ChatColor.GRAY;

public final class BreakListener implements Listener {

    private static final String DUST_NAME = GRAY + "" + BOLD + "Mining Dust";
    private static final String SKY_NAME = AQUA + "" + BOLD + "Sky Dust";
    private static final Map<Material, Integer> DUST_VALUES = new HashMap<>();
    private static final Map<Material, Integer> SKY_VALUES = new HashMap<>();

    static {
        DUST_VALUES.put(Material.STONE, 5);
        DUST_VALUES.put(Material.COAL_ORE, 7);
        DUST_VALUES.put(Material.LAPIS_ORE, 9);
        DUST_VALUES.put(Material.REDSTONE_ORE, 9);
        DUST_VALUES.put(Material.IRON_ORE, 12);
        DUST_VALUES.put(Material.GOLD_ORE, 15);
        DUST_VALUES.put(Material.DIAMOND_ORE, 17);
        DUST_VALUES.put(Material.EMERALD_ORE, 19);
        DUST_VALUES.put(Material.COAL_BLOCK, 14);
        DUST_VALUES.put(Material.LAPIS_BLOCK, 18);
        DUST_VALUES.put(Material.REDSTONE_BLOCK, 18);
        DUST_VALUES.put(Material.IRON_BLOCK, 24);
        DUST_VALUES.put(Material.GOLD_BLOCK, 30);
        DUST_VALUES.put(Material.DIAMOND_BLOCK, 34);
        DUST_VALUES.put(Material.EMERALD_BLOCK, 38);
    }

    static {
        SKY_VALUES.put(Material.POTATO, 15);
        SKY_VALUES.put(Material.CARROT, 15);
        SKY_VALUES.put(Material.WHEAT, 15);
        SKY_VALUES.put(Material.BEETROOT, 15);
        SKY_VALUES.put(Material.MELON_BLOCK, 15);
        SKY_VALUES.put(Material.PUMPKIN, 15);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBreak(BlockBreakEvent e) {
        Integer chance = DUST_VALUES.get(e.getBlock().getType());
        if (chance == null) return;

        if (current().nextInt(0, 100) > chance) return;

        Player player = e.getPlayer();
        player.getInventory().addItem(dust()).values().forEach(item -> player.getWorld().dropItem(player.getLocation(), item));
    }

    private ItemStack dust() {
        ItemStack item = new ItemStack(Material.MELON_SEEDS);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(DUST_NAME);

        item.setItemMeta(meta);

        return item;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFarmBreak(BlockBreakEvent e) {
        Integer chance = SKY_VALUES.get(e.getBlock().getType());
        if (chance == null) return;

        if (current().nextInt(0, 100) > chance) return;

        Player player = e.getPlayer();
        player.getInventory().addItem(skyDust()).values().forEach(item -> player.getWorld().dropItem(player.getLocation(), item));
    }

    private ItemStack skyDust() {
        ItemStack item = new ItemStack(Material.PUMPKIN_SEEDS);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(SKY_NAME);

        item.setItemMeta(meta);

        return item;

    }
}