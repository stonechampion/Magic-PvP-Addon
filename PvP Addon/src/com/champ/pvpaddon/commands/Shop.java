package com.champ.pvpaddon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.champ.pvpaddon.Addon;

public class Shop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		
		Player player = (Player) sender;
		
		if (!(sender instanceof Player)){
			System.out.println("You must be a player to run this command!");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("wshop")){
			
			player.openInventory(Addon.getInstance().getInv());
			
		}
		
		
		return false;
	}
	
	
	

}
