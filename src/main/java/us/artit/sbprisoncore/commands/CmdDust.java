package us.artit.sbprisoncore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.artit.sbprisoncore.utils.CustomItems;

public final class CmdDust implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                player.sendMessage("Here are the admin items :D");
                player.getInventory().addItem(CustomItems.SKY_DUST).values().forEach(item -> player.getWorld().dropItem(player.getLocation(), item));
                player.getInventory().addItem(CustomItems.SKY_DUST).values().forEach(item -> player.getWorld().dropItem(player.getLocation(), item));
                player.getInventory().addItem(CustomItems.MINE_DUST).values().forEach(item -> player.getWorld().dropItem(player.getLocation(), item));
                player.getInventory().addItem(CustomItems.MINE_DUST).values().forEach(item -> player.getWorld().dropItem(player.getLocation(), item));
            }
            else {
                player.sendMessage("No admin items for u, u need OP.");
            }
        }
        return true;
    }
}