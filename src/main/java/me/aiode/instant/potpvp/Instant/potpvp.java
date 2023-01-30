package me.aiode.instant.potpvp.Instant;

import me.aiode.instant.potpvp.Instant.Commands.PvpCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class potpvp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GREEN + "Instant Potpvp has loaded!");
        getCommand("pvp").setExecutor(new PvpCommand());
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "Instant Potpvp has disabled!");
    }
}
