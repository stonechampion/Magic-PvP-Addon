package com.champ.pvpaddon.pvp;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;

import com.champ.pvpaddon.AddonPlugin;

public class CastSpell implements Listener {
	
	
	
	
	@EventHandler
	public void onCast(PlayerAnimationEvent event){
		
		Player player = event.getPlayer();
		
		if (event.getAnimationType() == PlayerAnimationType.ARM_SWING){
			if (player.getInventory().getItemInMainHand().getType() == Material.STICK && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() == AddonPlugin.getInstance().getLangFile().get("stick_wand_name")){
				if (AddonPlugin.getInstance().cooldown.contains(player)){
					AddonPlugin.getInstance().getLangFile().get("wand_cooldown_message");
					
				} else {
					Magic.getInstance().castStickBeam(player);
				    AddonPlugin.getInstance().cooldown.add(player);
				    AddonPlugin.getInstance().startCooldown(player);
					
				}
			}
			if (player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() == AddonPlugin.getInstance().getLangFile().get("blazerod_wand_name")){
				if (AddonPlugin.getInstance().cooldown.contains(player)){
					AddonPlugin.getInstance().getLangFile().get("wand_cooldown_message");
					
				} else {
					Magic.getInstance().castBlazeBeam(player);
					AddonPlugin.getInstance().cooldown.add(player);
					AddonPlugin.getInstance().startCooldown(player);
					
				}
			}
		}
		
	}
	
	

}
