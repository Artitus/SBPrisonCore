package us.artit.sbprisoncore.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import us.artit.sbprisoncore.utils.CustomItems;

public final class PlaceListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlace(PlayerInteractEvent e) {
        if (!e.hasBlock() || !e.hasItem() || e.getClickedBlock().getType() != Material.SOIL) return;
        if (!CustomItems.MINE_DUST.isSimilar(e.getItem()) && !CustomItems.SKY_DUST.isSimilar(e.getItem())) return;

        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                (event.getItem() != null)) {
            if ((event.getClickedBlock().getType() == Material.OBSIDIAN) &&
                    (event.getItem().getType() == Material.BUCKET)) {
                event.getClickedBlock().setType(Material.AIR);
                player.getInventory().remove(event.getItem());
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAVA_BUCKET)});
            }
            if (event.getItem().getType() == Material.LAVA_BUCKET) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cIf the lava turns to obsidian right click with an empty bucket to turn it back into lava."));
            }
        }
    }

}

