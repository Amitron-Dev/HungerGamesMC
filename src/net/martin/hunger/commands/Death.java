package net.martin.hunger.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.martin.hunger.GMain;

public class Death implements CommandExecutor {
	
	private GMain main;
	
	public Death(GMain main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(p.hasPermission("hunger.deathlist")) {
			
			
			if(main.getDeath().isEmpty()) {
				p.sendMessage("§cAucun joueurs n'est morts.");
			}else {
				StringBuilder deathNames = new StringBuilder("Liste des joueurs morts : ");
				
				for(Player death : main.getDeath()) {	
					deathNames.append(death.getName()).append(", ");
				}
				
				
				p.sendMessage(deathNames.toString());
			}
			
			
		}
		return false;
	}

}
