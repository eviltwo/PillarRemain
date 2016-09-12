package com.eviltwo.pillarsremain;

import org.bukkit.plugin.Plugin;

public class ConfigLoader {
	
	private Plugin plugin;
	private double createPillarProbability;
	
	public ConfigLoader(Plugin plugin){
		this.plugin = plugin;
		LoadConfig();
	}
	
	private void LoadConfig(){
		plugin.saveDefaultConfig();
		
		createPillarProbability = plugin.getConfig().getDouble("createPillarProbability");
		
		plugin.saveConfig();
	}
	
	public double GetPillarProbability(){
		return createPillarProbability;
	}
}
