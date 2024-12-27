package net.martin.hunger.listeners;

import java.util.Arrays;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.martin.hunger.GMain;
import net.martin.hunger.enums.GState;

public class JoinListeners implements Listener {
	
	private GMain main;
	
	public JoinListeners(GMain main) {
		this.main = main;
		
	}
	
	public void onJoin(PlayerJoinEvent e ) {
		Player p = e.getPlayer();
		
		if(p.hasPermission("hunger.host")) {
			
			if(main.isState(GState.WAITING)) {
				ItemStack start = new ItemStack(Material.EMERALD);
				ItemMeta startm = start.getItemMeta();
				startm.setDisplayName("§a§lStart");
				startm.setLore(Arrays.asList("§4Start the Hunger Games"));
				start.setItemMeta(startm);
				p.getInventory().clear();
				p.getInventory().setItem(0, start);
				p.setGameMode(GameMode.CREATIVE);
				e.setJoinMessage("§4L'administrateur " + p.getName() + " à rejoint le serveur.");
				
			}else {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("§aLe jeu à déjà démarré");
				
			}
			
			
			
		}else {
			if(!p.hasPermission("hunger.host")) {
				
				if(main.isState(GState.WAITING)) {
					e.setJoinMessage("§e[HUNGER GAMES] " + p.getName() + " à rejoint !");
					p.getInventory().clear();
					p.teleport(main.spawn());
					main.getPlayers().add(p);
					
				}else {
					e.setJoinMessage(null);
					p.setGameMode(GameMode.SPECTATOR);
				}
				
				
			}
		}
	}

}
