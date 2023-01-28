package me.aiode.instant.potpvp.Instant;

import me.aiode.instant.potpvp.Instant.Commands.PvpCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class potpvp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Instant Potpvp has loaded!");

        getCommand("pvp").setExecutor(new PvpCommand());
        // getCommand("pvp reload").setExecutor(this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Instant Potpvp has disabled!");
    }
}
