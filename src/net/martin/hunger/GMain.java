package net.martin.hunger;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.martin.hunger.commands.Death;
import net.martin.hunger.enums.GState;
import net.martin.hunger.listeners.InteractListeners;
import net.martin.hunger.listeners.JoinListeners;
import net.martin.hunger.listeners.LeaveListeners;

public class GMain extends JavaPlugin {
	
	public ArrayList<Player> players = new ArrayList<>();
	public ArrayList<Player> death = new ArrayList<>();
	public ArrayList<Location> spawns = new ArrayList<>();
	public GState state;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		setSpawns();
		setState(GState.WAITING);
		Bukkit.getPluginManager().registerEvents(new JoinListeners(this), null);
		Bukkit.getPluginManager().registerEvents(new LeaveListeners(this), null);
		Bukkit.getPluginManager().registerEvents(new InteractListeners(this), null);
		getCommand("deathlist").setExecutor(new Death(this));
		
		
	}
	
	
	public void setSpawns() {
				// Get Spawns
		
		// World
		World confworld = Bukkit.getWorld(getConfig().getString("location.spawns.world"));
				
		// 1
				
		Double onex = getConfig().getDouble("location.spawns.one.x");
		Double oney = getConfig().getDouble("location.spawns.one.y");
		Double onez = getConfig().getDouble("location.spawns.one.z");
				
		Location one = new Location(confworld, onex, oney, onez);
		
		getSpawns().add(one);
		
				
		// 2
				
		Double twox = getConfig().getDouble("location.spawn.two.x");
		Double twoy = getConfig().getDouble("location.spawn.two.y");
		Double twoz = getConfig().getDouble("location.spawn.two.z");
				
		Location two = new Location(confworld, twox, twoy, twoz);
		
		getSpawns().add(two);
				
		// 3
				
		Double threex = getConfig().getDouble("location.spawn.three.x");
		Double threey = getConfig().getDouble("location.spawn.three.y");
		Double threez = getConfig().getDouble("location.spawn.three.z");
				
		Location three = new Location(confworld, threex, threey, threez);
		
		getSpawns().add(three);
				
		// 4 
				
		Double fourx = getConfig().getDouble("location.spawn.four.x");
		Double foury = getConfig().getDouble("location.spawn.four.y");
		Double fourz = getConfig().getDouble("location.spawn.four.z");
				
		Location four = new Location(confworld, fourx, foury, fourz);
		
		getSpawns().add(four);
				
		// 5
				
		Double fivex = getConfig().getDouble("location.spawn.five.x");
		Double fivey = getConfig().getDouble("location.spawn.five.y");
		Double fivez = getConfig().getDouble("location.spawn.five.z");
				
		Location five = new Location(confworld, fivex, fivey, fivez);
		
		getSpawns().add(five);
				
		// 6
				
		Double sixx = getConfig().getDouble("location.spawn.six.x");
		Double sixy = getConfig().getDouble("location.spawn.six.y");
		Double sixz = getConfig().getDouble("location.spawn.six.z");
				
		Location six = new Location(confworld, sixx, sixy, sixz);
		
		getSpawns().add(six);
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
	
	public List<Location> getSpawns() {
		return spawns;
	}
	
	
	public boolean isState(GState state) {
		return this.state == state;
	}
	
	public void setState(GState state) {
		this.state = state;
	}

}
