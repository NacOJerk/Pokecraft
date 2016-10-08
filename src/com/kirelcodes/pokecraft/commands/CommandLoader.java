package com.kirelcodes.pokecraft.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kirelcodes.pokecraft.pokemons.air.Voltorb;
import com.kirelcodes.pokecraft.pokemons.ground.Pikachu;

public class CommandLoader {
	public static void loadDemUP() {
		MajorCommand major = new MajorCommand("pokecraft")
				.setArgsMessage("Dang bitch you better type some shit")
				.setNoPermission("No perms slut")
				.setNoSuchCommandMessage(
						"Dannnnnnng you trying to fuck with me ?").setPrefix(ChatColor.AQUA + "[POKECRAFT]");
		CommandManager cm = major.getCommandManager();
		cm.addCommand(new ExtendedCommandBase("pikachu") {
			
			@Override
			public List<String> tabComplete(CommandSender sender, String alias,
					String[] args) {

				return null;
			}
			
			@Override
			public boolean executeCommand(CommandSender sender, String command,
					String[] args, boolean sentViaPlayer) {
				if(!sentViaPlayer)
					return false;
				new Pikachu(((Player)sender).getLocation().add(1, 0, 1));
				return false;
			}
		});
		cm.addCommand(new ExtendedCommandBase("Voltorb") {
			
			@Override
			public List<String> tabComplete(CommandSender sender, String alias,
					String[] args) {

				return null;
			}
			
			@Override
			public boolean executeCommand(CommandSender sender, String command,
					String[] args, boolean sentViaPlayer) {
				if(!sentViaPlayer)
					return false;
				new Voltorb(((Player)sender).getLocation().add(1, 0, 1));
				return false;
			}
		});
	}
	
}
