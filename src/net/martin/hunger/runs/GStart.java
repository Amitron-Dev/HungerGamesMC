package net.martin.hunger.runs;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import net.martin.hunger.GMain;

public class GStart extends BukkitRunnable{
	
	private GMain main;
	
	public GStart(GMain main) {
		this.main = main;
	}
	

	private int timer = 20;
	
	
	
	
	@Override
	public void run() {
		
		
		if(timer == 20 || timer == 15 || timer == 10 || timer == 9 || timer == 8 || timer == 7 || timer == 6 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
			Bukkit.broadcastMessage("§e[HUNGER GAMES] §r§6Le jeu demarre dans " + timer);
			
		}
		
		
		if(timer == 0) {
			
		}
		
		
		
		timer--;
		
	}

}
