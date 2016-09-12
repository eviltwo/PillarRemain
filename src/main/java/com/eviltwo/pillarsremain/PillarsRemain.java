package com.eviltwo.pillarsremain;

import org.bukkit.plugin.java.JavaPlugin;

public class PillarsRemain extends JavaPlugin {
	
	public ConfigLoader configLoader;
	
	@Override
	public void onEnable() {
		configLoader = new ConfigLoader(this);
		getServer().getPluginManager().registerEvents(new PREventListener(this),this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
