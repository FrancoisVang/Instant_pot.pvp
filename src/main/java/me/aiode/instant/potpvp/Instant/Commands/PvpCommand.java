package me.aiode.instant.potpvp.Instant.Commands;

import me.aiode.instant.potpvp.Instant.potpvp;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PvpCommand implements CommandExecutor {

    //Implements the main class
    Plugin plugin = potpvp.getPlugin(potpvp.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by a player.");
        }

        Player p = (Player) sender;





        if (p.hasPermission("instantpotpvp.pvp")) {
            if (!p.getInventory().isEmpty()) {
                //checks if inventory and armor set is empty.
                sender.sendMessage("You must clear your inventory and armor.");
            } else if (p.getInventory().isEmpty()) {
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);


                // CONFIG Material ID
                //
                // Create the armor
                String armor = plugin.getConfig().getString("armor_type").toUpperCase();
                Material sword = Material.valueOf(plugin.getConfig().getString("sword_type"));


                if(armor.toString().contains("diamond".toUpperCase())){
                    ItemStack bootsDiamond = new ItemStack(Material.DIAMOND_BOOTS, 1);
                    ItemStack leggingsDiamond = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                    ItemStack chestplateDiamond = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                    ItemStack helmetDiamond = new ItemStack(Material.DIAMOND_HELMET, 1);
                    //Enchantments
                    bootsDiamond.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Boots Protection Level"));
                    leggingsDiamond.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Leggings Protection Level"));
                    chestplateDiamond.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Chestplate Protection Level"));
                    helmetDiamond.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Helmet Protection Level"));
                    // Create the diamond sword
                    ItemStack swordDiamond = new ItemStack(Material.DIAMOND_SWORD);
                    swordDiamond.addEnchantment(Enchantment.DAMAGE_ALL, plugin.getConfig().getInt("Sword Sharpness Level"));

                    // Equip sword and armor
                    p.getInventory().setHelmet(helmetDiamond);
                    p.getInventory().setChestplate(chestplateDiamond);
                    p.getInventory().setLeggings(leggingsDiamond);
                    p.getInventory().setBoots(bootsDiamond);

                    p.getInventory().setItem(0, swordDiamond);

                    // Ready message.
                    sender.sendMessage("You are ready to pvp!");

                    // STUCK HERE )(_)(_)_()_*_))_*_*)__*)_*_)*)*_)*_)*_)*_)*_)*
                } else if (armor.toString().contains("nether".toUpperCase())) {
                    ItemStack bootsNetherite = new ItemStack(Material.NETHERITE_BOOTS, 1);
                    ItemStack leggingsNetherite = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
                    ItemStack chestplateNetherite = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
                    ItemStack helmetNetherite = new ItemStack(Material.NETHERITE_HELMET, 1);

                    bootsNetherite.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Boots Protection Level"));
                    leggingsNetherite.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Leggings Protection Level"));
                    chestplateNetherite.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Chestplate Protection Level"));
                    helmetNetherite.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, plugin.getConfig().getInt("Helmet Protection Level"));
                    // Create the diamond sword
                    ItemStack swordNetherite = new ItemStack(Material.NETHERITE_SWORD);
                    swordNetherite.addEnchantment(Enchantment.DAMAGE_ALL, plugin.getConfig().getInt("Sword Sharpness Level"));

                    // Equip sword and armor
                    p.getInventory().setHelmet(helmetNetherite);
                    p.getInventory().setChestplate(chestplateNetherite);
                    p.getInventory().setLeggings(leggingsNetherite);
                    p.getInventory().setBoots(bootsNetherite);

                    p.getInventory().setItem(0, swordNetherite);

                    // Ready message.
                    sender.sendMessage("You are ready to pvp!");
                }


            }
            else {
                // CONFIG
            sender.sendMessage(ChatColor.RED + "You do not have access to this command.");
        }
    }

        /**
        if(sender instanceof Player || sender instanceof ConsoleCommandSender)
        {
            if(strings.length == 1 && strings[0] == "reload" && sender.hasPermission("instantpvp.reload")) {

                //Save then reload Default Config
                plugin.saveDefaultConfig();
                plugin.reloadConfig();
            }
        }
        else {
            sender.sendMessage("Invalid Usage: /pvp reload");
        } **/

        return true;
    }
}
