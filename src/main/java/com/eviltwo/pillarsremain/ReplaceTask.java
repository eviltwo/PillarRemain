package com.eviltwo.pillarsremain;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
 
public class ReplaceTask extends BukkitRunnable {
	private Material[] fences = {
			Material.FENCE,
			Material.SPRUCE_FENCE,
			Material.BIRCH_FENCE,
			Material.JUNGLE_FENCE,
			Material.ACACIA_FENCE,
			Material.DARK_OAK_FENCE,
	};
	private final PillarsRemain plugin;
	
    private Block[] blocks;
    private Material[] materials;
    private int[] blockIDs;
 
    public ReplaceTask(PillarsRemain plugin, int counter, Block[] blocks, Material[] materials, int[] blockIDs) {
        if (counter < 1) {
            throw new IllegalArgumentException("counter more than 0!");
        } else {
        	this.plugin = plugin;
            this.blocks = blocks;
            this.materials = materials;
            this.blockIDs = blockIDs;
            this.runTaskTimer(plugin, counter, 1);
        }
    }
 
    @Override
    public void run() {
    	for(int i=0; i<blocks.length; i++){
    		if(new Random().nextDouble() > plugin.configLoader.GetPillarProbability()){
    			continue;
    		}
    		if(materials[i] == Material.WOOD){
    			Location loc = blocks[i].getLocation();
				loc.getBlock().setType(fences[blockIDs[i]]);
    		}
    		if(materials[i] == Material.COBBLESTONE){
    			Location loc = blocks[i].getLocation();
				loc.getBlock().setType(Material.COBBLE_WALL);
    		}
    	}
        this.cancel();
    }
}