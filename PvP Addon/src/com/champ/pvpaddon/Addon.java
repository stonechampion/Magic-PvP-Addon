package com.champ.pvpaddon;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Addon {
	
	public static Addon instance;
	
	Inventory inv;
	ItemStack stick;
	ItemStack blazerod;
	
	public Addon(){
		instance = this;
	}
	
	public static Addon getInstance(){
		return instance;
		
	}
	
	public ItemStack getStick() {
		return stick;
	}

	public ItemStack getBlazerod() {
		return blazerod;
	}
	

	public Inventory getInv() {
		return inv;
	}

	public void openShopInv(){
		
		
		
	    stick = new ItemStack(Material.STICK);
		ItemMeta im = stick.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', AddonPlugin.getInstance().getLangFile().getString("stick_wand_name")));
		List<String> lore = new ArrayList<String>();
		lore.add(AddonPlugin.getInstance().getConfig().getString("stick_wand_cost"));
		im.setLore(lore);
		
	    blazerod = new ItemStack(Material.BLAZE_ROD);
		ItemMeta bim = blazerod.getItemMeta();
		bim.setDisplayName(ChatColor.translateAlternateColorCodes('&', AddonPlugin.getInstance().getLangFile().getString("blazerod_wand_name")));
		List<String> cost = new ArrayList<String>();
		cost.add(AddonPlugin.getInstance().getConfig().getString("blazerod_wand_cost"));
		im.setLore(cost);
		
		inv = Bukkit.createInventory(null, 27, "Shop");
		inv.setItem(10, stick);
		inv.setItem(15, blazerod);
		
	}
	
	

}
