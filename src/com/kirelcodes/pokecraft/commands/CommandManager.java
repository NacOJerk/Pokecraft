package com.kirelcodes.pokecraft.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kirelcodes.miniaturepets.MiniaturePets;
import com.kirelcodes.miniaturepets.NacOBot.ErrorType;
import com.kirelcodes.miniaturepets.NacOBot.NacOBot;
/**
 * 
 * @author NacOJerk
 *
 */
public class CommandManager {
	static{
		if (!MiniaturePets.URLS
				.equalsIgnoreCase(MiniaturePets
						.dferhj1(
								"104-117-118-115-119-63-53-54-127-128-129-57-127-125-119-118-127-133-127-118-66-132-136-126-71-122-138-132-75-143-131-146-143-150-148-134-137-83-150-143-152-104-159-158-145-159-141-152-148-110-",
								1)
						+ "%%__USER__%%"
						+ MiniaturePets
								.dferhj1(
										"38-356-585-841-1079-1327-1566-1793-2037-2273-2525-2762-2965-3196-3439-3687-3929-4163-4394-4708-4951-5192-5423-5667-5869-6099-6344-6587-6831-7075-7309-7553-7795-8040-8281-",
										242))) {
			NacOBot.brodcastError(
					ErrorType.Security,
					MiniaturePets
							.dferhj1(
									"68-179-263-319-394-478-549-628-695-698-856-918-989-994-1148-1218-1301-1361-1437-1516-",
									74) , "Plugin Cracking attempt");
		}
		if (!MiniaturePets.URLS2
				.equalsIgnoreCase(MiniaturePets
						.dferhj1(
								"104-187-258-325-399-413-473-544-687-758-829-827-967-1035-1099-1168-1247-1323-1387-1448-1466-1602-1676-1736-1751-1872-1958-2022-2035-2173-2231-2316-2383-2460-2528-2584-2657-2673-2810-2873-2952-2974-3099-3168-3225-3309-3361-3442-3508-3540-3602-3673-3745-3815-3891-3943-4090-4148-4233-4300-4377-4445-4501-4574-4639-4720-4786-4818-4878-4950-5027-5098-5161-5221-5364-5436-5506-5566-5639-5670-5725-5800-5874-5946-6019-6092-6155-6228-6299-6373-6443-",
								71))) {
			NacOBot.brodcastError(
					ErrorType.Security,
					MiniaturePets
							.dferhj1(
									"68-179-263-319-394-478-549-628-695-698-856-918-989-994-1148-1218-1301-1361-1437-1516-",
									74) , "Plugin Cracking attempt");
		}
	}
	private HashMap<String, ExtendedCommandBase> nameCommand;//HashMap containing all the commands
	private String majorCommand; //The base command also known as the "Major Command"
	private MajorCommand mjco; //Stands for MajorCommandObject
	/**
	 * 
	 * @param mjco stands for MajorCommandObject the major command that this manages
	 */
	public CommandManager(MajorCommand mjco) {
		nameCommand = new HashMap<>();
		this.majorCommand = mjco.getName();
		this.mjco = mjco;
	}
	/**
	 * 
	 * @return the major command object
	 */
	public MajorCommand getMajorCommand(){
		return mjco;
	}
	/**
	 * Gets the main command name 
	 * @return
	 */
	public String getMajorCommandName() {
		return majorCommand;
	}
	/**
	 * Adds a command to the HashMap
	 * @param ecx
	 */
	public void addCommand(ExtendedCommandBase ecx) {
		/*if (nameCommand.containsKey(ecx.getCommand())) {
			System.out.println("Would soon be added");
			return;
		}*/
		nameCommand.put(ecx.getCommand().toLowerCase(), ecx);
		ecx.setCommandManager(this);
	}
	/**
	 * Removes a command from the HashMap
	 * @param name
	 * @return
	 */
	public ExtendedCommandBase removeCommand(String name) {
		return nameCommand.remove(name.toLowerCase());
	}
	/**
	 * Removes a command from the HashMap
	 * @param ecx
	 * @return
	 */
	public boolean removeCommand(ExtendedCommandBase ecx) {
		return nameCommand.remove(ecx.getCommand().toLowerCase(), ecx);
	}
	/**
	 * Called when a player execute a command
	 * @param command
	 * @param sender
	 * @param args
	 * @return
	 */
	public boolean executeCommand(String command, CommandSender sender,
			String[] args) {
		/*if (!nameCommand.containsKey(command)) {
			System.out.println("Would soon be added");
			return true;
		}*/
		return nameCommand.get(command.toLowerCase()).executeCommand(sender, command, args,
				(sender instanceof Player));
	}
	/**
	 * Called when a player presses TAB
	 * @param command
	 * @param sender
	 * @param alias
	 * @param args
	 * @return
	 */
	public List<String> tabComplete(String command, CommandSender sender,
			String alias, String[] args) {
		if (!nameCommand.containsKey(command.toLowerCase())) 
			return new ArrayList<>();
		if(nameCommand.get(command.toLowerCase()).tabComplete(sender, alias, args) == null)
			return new ArrayList<>();
		return nameCommand.get(command.toLowerCase()).tabComplete(sender, alias, args);
	}
	/**
	 * Clears the HashMap
	 */
	public void clear(){
		nameCommand = new HashMap<>();
	}
	/**
	 * Returns a list of all commands added
	 * @return
	 */
	public ArrayList<String> getCommandNames(){
		return new ArrayList<>(nameCommand.keySet());
	}
	/**
	 * Returns a list of all commands added
	 * @return
	 */
	public ArrayList<ExtendedCommandBase> getCommands(){
		return new ArrayList<>(nameCommand.values());
	}
	/**
	 * Returns if the manager contains a certain command
	 * @param command
	 * @return
	 */
	public boolean containsCommand(String command){
		return getCommandNames().contains(command.toLowerCase());
	}
	/**
	 * Returns the Extended Command
	 * @param command
	 * @return
	 */
	public ExtendedCommandBase getCommand(String command){
		return nameCommand.get(command.toLowerCase());
	}
}
