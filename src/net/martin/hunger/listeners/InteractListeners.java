package net.martin.hunger.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.martin.hunger.GMain;
import net.martin.hunger.enums.GState;
import net.martin.hunger.runs.GStart;

public class InteractListeners implements Listener {
	
	private GMain main;
	
	public InteractListeners(GMain main) {
		this.main = main;
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		ItemStack it = e.getItem();
		Player p = e.getPlayer();
		
		if(main.isState(GState.WAITING)) {
			if(it.getType() == Material.EMERALD) {
				if(p.hasPermission("hunger.start")) {
					it.setType(Material.AIR);
					p.sendMessage("§eVous avez démarrer le jeu !");
					
					GStart start = new GStart(main);
					start.runTaskTimer(main, 0, 20);
					
				}
			}
		}
	}

}
