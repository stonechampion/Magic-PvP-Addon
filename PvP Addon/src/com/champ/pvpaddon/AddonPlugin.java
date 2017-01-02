package com.champ.pvpaddon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.champ.pvpaddon.commands.NPC;
import com.champ.pvpaddon.commands.Shop;
import com.champ.pvpaddon.events.InvClick;
import com.champ.pvpaddon.pvp.CastSpell;

public class AddonPlugin extends JavaPlugin {
	
	public static AddonPlugin instance;
	
	 File langFile;
	 FileConfiguration langConfig;
	 
	 public ArrayList<Player> cooldown = new ArrayList<Player>();
	
	public void onEnable(){
		instance = this;
		
		langFile = new File(this.getDataFolder(), "/lang.yml");
		
		Bukkit.getServer().getPluginManager().registerEvents(new CastSpell(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InvClick(), this);
		
		getCommand("wshop").setExecutor(new Shop());
		getCommand("wnpc").setExecutor(new NPC());
		
		setupConfig();
		setupLangFile();
	}
	
	public void onDisable(){
		
	}
	
	public static AddonPlugin getInstance(){
		return instance;
	}
	
	public void setupConfig(){
		
		FileConfiguration config = getConfig();
		
		saveDefaultConfig();
		config.options().copyDefaults(true);
		
	}
	
	public void setupLangFile(){
		
		langConfig = YamlConfiguration.loadConfiguration(langFile);
		
		if(!langFile.exists()){
			this.getDataFolder().mkdir();
			try {
				langConfig.save(langFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public FileConfiguration getLangFile(){
		return langConfig;
		
	}
	
	
	public void startCooldown(Player player){
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			
			public void run(){
				cooldown.remove(player);
			}
			
		}, 100);
		
	}
	
	

}
