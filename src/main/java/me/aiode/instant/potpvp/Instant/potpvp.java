package me.aiode.instant.potpvp.Instant;

import me.aiode.instant.potpvp.Instant.Commands.PvpCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class potpvp extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("pvp").setExecutor(new PvpCommand());
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&aInstant Potpvp has loaded!"));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&aInstant Potpvp has disabled!"));
    }
}
