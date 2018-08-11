package us.artit.sbprisoncore;

import com.sxtanna.recipe.Recipes;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import us.artit.sbprisoncore.commands.CmdDust;
import us.artit.sbprisoncore.listeners.*;

import java.io.File;

public final class SBPrisonCore extends JavaPlugin {

    public static Permission perms = null;
    public static Plugin plugin;

    @Override
    public void onEnable() {
        final FileConfiguration config = this.getConfig();
        if (!new File(this.getDataFolder(), "config.yml").exists()) {
            config.options().copyDefaults(true);
        }
        saveDefaultConfig();
        plugin = this;
        Recipes.enable(this);
        new CraftingListener();
        this.listeners();
        this.commands();
    }

    public void listeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new RightClickListener(), this);
        pm.registerEvents(new BreakListener(), this);
        pm.registerEvents(new PlaceListener(), this);
    }

    public void commands() {
        getCommand("dust").setExecutor(new CmdDust());
    }

    private boolean setupPermission() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}


