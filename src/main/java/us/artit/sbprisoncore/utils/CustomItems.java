package us.artit.sbprisoncore.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems {
    public static final ItemStack MINE_DUST, SKY_DUST, KNOWLEDGE_SCROLL, CHEST, TRAPPED_CHEST;

    static {
        MINE_DUST = new ItemStack(Material.MELON_SEEDS);

        ItemMeta mineMeta = MINE_DUST.getItemMeta();
        mineMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Mining Dust");
        MINE_DUST.setItemMeta(mineMeta);


        SKY_DUST = new ItemStack(Material.PUMPKIN_SEEDS);

        ItemMeta skyMeta = SKY_DUST.getItemMeta();
        skyMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Sky Dust");
        SKY_DUST.setItemMeta(skyMeta);

        KNOWLEDGE_SCROLL = new ItemStack(Material.PAPER);

        ItemMeta knowledgeMeta = KNOWLEDGE_SCROLL.getItemMeta();
        knowledgeMeta.setDisplayName(ChatColor.WHITE + "Knowledge Scroll" + ChatColor.GRAY + "" + ChatColor.BOLD + " (Right Click)");
        KNOWLEDGE_SCROLL.setItemMeta(knowledgeMeta);

        CHEST = new ItemStack(Material.CHEST);
        TRAPPED_CHEST = new ItemStack(Material.TRAPPED_CHEST);


    }

}