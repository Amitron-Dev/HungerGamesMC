package net.martin.hunger;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.martin.hunger.commands.Death;
import net.martin.hunger.enums.GState;
import net.martin.hunger.listeners.JoinListeners;
import net.martin.hunger.listeners.LeaveListeners;

public class GMain extends JavaPlugin {
	
	public ArrayList<Player> players = new ArrayList<>();
	public ArrayList<Player> death = new ArrayList<>();
	public GState state;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		setState(GState.WAITING);
		Bukkit.getPluginManager().registerEvents(new JoinListeners(this), null);
		Bukkit.getPluginManager().registerEvents(new LeaveListeners(this), null);
		getCommand("deathlist").setExecutor(new Death(this));
	}
	
	public Location spawn() {
		
		// Get world
		String world = getConfig().getString("location.spawn.world");
		
		// Get Locs
		Double spawnx = getConfig().getDouble("location.spawn.x");
		Double spawny = getConfig().getDouble("location.spawn.y");
		Double spawnz = getConfig().getDouble("location.spawn.z");
		
		
		// Create Location Variable
		Location spawn = new Location(Bukkit.getWorld(world), spawnx, spawny, spawnz);
		
		return spawn;
		
	}
	
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public List<Player> getDeath() {
		return death;
	}
	
	public boolean isState(GState state) {
		return this.state == state;
	}
	
	public void setState(GState state) {
		this.state = state;
	}

}
