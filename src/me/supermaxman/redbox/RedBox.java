package me.supermaxman.redbox;

import java.util.logging.Logger;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class RedBox extends JavaPlugin implements Listener{
	public static RedBox plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	
	
	@Override
	public void onDisable() {
		this.logger.info("RedBox Disabled.");
		
	}


	
	@Override
	public void onEnable() {
        getServer().getPluginManager().registerEvents(new RedBox(), this);

		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled! W00T!");
		
	
	
	
	}
	
	
	@EventHandler
	public void onBlockPistonExtend(BlockPistonExtendEvent event){
		Block block = event.getBlock();
		Block jukebox = block.getRelative(0,2,0);
		if ((block.getType() == Material.PISTON_BASE)&&
			(jukebox.getType() == Material.JUKEBOX)&&
			(block.getRelative(0,1,0).getType() == Material.AIR)){
			Jukebox redbox = (Jukebox)jukebox.getState();
			redbox.setPlaying(redbox.getPlaying());
		}
	}
	
}
