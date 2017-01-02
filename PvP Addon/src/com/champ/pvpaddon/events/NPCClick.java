package com.champ.pvpaddon.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.champ.pvpaddon.Addon;






public class NPCClick implements Listener {
	
	
	@EventHandler
	public void onNPCClick(PlayerInteractEntityEvent event){
		
		Entity entity = event.getRightClicked();
		
		if (entity.getCustomName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Wand Shop")){
			Addon.getInstance().openShopInv();
		}
		
	}

}
