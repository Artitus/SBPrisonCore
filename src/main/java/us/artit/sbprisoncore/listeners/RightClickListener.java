package us.artit.sbprisoncore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import us.artit.sbprisoncore.utils.CustomItems;

public final class RightClickListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void RightClickListener(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (!e.hasItem() || !e.getItem().isSimilar(CustomItems.KNOWLEDGE_SCROLL)) {
                return;
            } else {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "te add " + player + " " + e.getItem().getAmount());
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "+ " + e.getItem().getAmount() + " Knowledge");
                e.getItem().setAmount(0);
            }
        } else {
            return;
        }
    }
}
