package me.aiode.instant.potpvp.Instant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {


        if(!(sender instanceof Player))
        {
            sender.sendMessage("This command can only be used by a player.");
        }

        Player p = (Player) sender;
        // Create the armor
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS,1);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS,1);
        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
        ItemStack head = new ItemStack(Material.DIAMOND_HELMET,1);
        // Adding the enchantments
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        head.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        // Create the diamond sword
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        if(p.hasPermission("instantpotpvp.pvp"))
        {
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.getInventory().setHelmet(head);
            p.getInventory().setChestplate(chestplate);
            p.getInventory().setLeggings(leggings);
            p.getInventory().setBoots(boots);

            p.getInventory().setItem(0, sword);

            // Create the strength and speed potion

            sender.sendMessage("You are ready to pvp!");
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have access to this command.");
        }
        return true;
    }
}
