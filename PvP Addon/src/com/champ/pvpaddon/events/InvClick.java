package com.champ.pvpaddon.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.champ.pvpaddon.AddonPlugin;



public class InvClick implements Listener {
	
	
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		
		if(event.getClickedInventory().getTitle() == "Shop"){
			if(event.getClickedInventory().getItem(10) != null){
				if(event.getClickedInventory().getItem(10).getItemMeta().getDisplayName() == AddonPlugin.getInstance().getLangFile().get("stick_wand_name")){
					event.setCancelled(true);
					
					//TODO: Take away a cost
				}
			} else if (event.getClickedInventory().getItem(15) != null){
				if (event.getClickedInventory().getItem(15).getItemMeta().getDisplayName() == AddonPlugin.getInstance().getLangFile().getString("blazerod_wand_name")){
					event.setCancelled(true);
					
					//TODO: Take away a cost
				}
			}
		}
		
	}

}
