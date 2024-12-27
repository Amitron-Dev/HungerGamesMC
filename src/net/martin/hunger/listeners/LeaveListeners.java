package net.martin.hunger.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.martin.hunger.GMain;
import net.martin.hunger.enums.GState;

public class LeaveListeners implements Listener {
	private GMain main;
	
	public LeaveListeners(GMain main) {
		this.main = main;
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(!p.hasPermission("hunger.host")){
			
			if(main.isState(GState.WAITING)) {
				e.setQuitMessage("§e§l[HUNGER GAMES] " + p.getName() + " à quitté la partie !");
				main.getPlayers().remove(p);
			}else {
				if(main.getPlayers().contains(p)) {
					main.getPlayers().remove(p);
					main.getDeath().add(p);
				}
				e.setQuitMessage(null);
			}
		}
	}

}
