package com.champ.pvpaddon.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.champ.pvpaddon.Addon;
import com.champ.pvpaddon.AddonPlugin;



public class InvClick implements Listener {
	
	
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		
		ItemStack clickedItem = event.getCurrentItem();
		
		Player player = (Player) event.getWhoClicked();
		
		if(event.getClickedInventory().getName() == "Shop"){
			if(clickedItem.getItemMeta().getDisplayName() == AddonPlugin.getInstance().getLangFile().get("stick_wand_name")){
				if(player.getExpToLevel() < AddonPlugin.getInstance().getConfig().getInt("stick_wand_cost")){
					event.setCancelled(true);
					player.sendMessage(AddonPlugin.getInstance().getLangFile().getString("not_enough_exp_message"));
					
				} else if (player.getExpToLevel() >= AddonPlugin.getInstance().getConfig().getInt("stick_wand_cost")){
					event.setCancelled(true);
					player.setTotalExperience(player.getExpToLevel() - AddonPlugin.getInstance().getConfig().getInt("stick_wand_cost"));
					player.getInventory().addItem(Addon.getInstance().getStick());
					
				}
				
				
			} 
			
			if(clickedItem.getItemMeta().getDisplayName() == AddonPlugin.getInstance().getLangFile().get("blazerod_wand_name")){
				if(player.getExpToLevel() < AddonPlugin.getInstance().getConfig().getInt("blazerod_wand_cost")){
					event.setCancelled(true);
					player.sendMessage(AddonPlugin.getInstance().getLangFile().getString("not_enough_exp_message"));
					
				} else if (player.getExpToLevel() >= AddonPlugin.getInstance().getConfig().getInt("blazerod_wand_cost")){
					event.setCancelled(true);
					player.setTotalExperience(player.getExpToLevel() - AddonPlugin.getInstance().getConfig().getInt("blazerod_wand_cost"));
					player.getInventory().addItem(Addon.getInstance().getBlazerod());
					
				}
			}
				
		}   
		
	}

}
