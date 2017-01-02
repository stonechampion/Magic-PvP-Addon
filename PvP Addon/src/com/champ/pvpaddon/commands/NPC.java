package com.champ.pvpaddon.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.champ.pvpaddon.AddonPlugin;

public class NPC implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		
		Player player = (Player) sender;
		
		if (!(sender instanceof Player)){
			System.out.println("You must be a player to run this command!");
			return true;
		}
		
		if (!player.hasPermission("npc.spawn")) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', AddonPlugin.getInstance().getLangFile().getString("no_permission")));
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("wnpc")) {
			
			Villager npcshop = player.getWorld().spawn(player.getLocation(), Villager.class);
			npcshop.setAdult();
			npcshop.setCustomName(ChatColor.GOLD + "" + ChatColor.BOLD +  "Wand Shop");
			npcshop.setCustomNameVisible(true);
			npcshop.setProfession(Profession.NORMAL);
			npcshop.setCanPickupItems(false);
			npcshop.setInvulnerable(true);
			npcshop.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 10));
			//TODO: Add Potion Effect
			
			
		}
		
		return false;
	}
	
	

}
