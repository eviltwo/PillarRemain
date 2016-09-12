package com.eviltwo.pillarsremain;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class PREventListener implements Listener {
	
	private final PillarsRemain plugin;
	
	public PREventListener(PillarsRemain plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        Block[] blocks = e.blockList().toArray(new Block[e.blockList().size()]);
        Material[] materials = new Material[e.blockList().size()];
        int[] blockIDs = new int[e.blockList().size()];
        for(int i=0; i<e.blockList().size(); i++){
        	materials[i] = blocks[i].getType();
        	blockIDs[i] = blocks[i].getData();
        }
        new ReplaceTask(plugin, 1, blocks, materials, blockIDs);
    }
	
	@EventHandler
	public void onBlockBurn(BlockBurnEvent e){
		Block[] blocks = {e.getBlock()};
		Material[] materials = {e.getBlock().getType()};
		int[] blockIDs = {e.getBlock().getData()};
		new ReplaceTask(plugin, 1, blocks, materials, blockIDs);
	}
}
