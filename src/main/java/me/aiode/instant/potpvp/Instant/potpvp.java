package me.aiode.instant.potpvp.Instant;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class potpvp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Instant Potpvp has loaded!");

        getCommand("pvp").setExecutor(new cmd());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Instant Potpvp has loaded!");
    }
}
