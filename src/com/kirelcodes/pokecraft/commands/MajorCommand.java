package com.kirelcodes.pokecraft.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.defaults.BukkitCommand;

import com.kirelcodes.miniaturepets.MiniaturePets;
import com.kirelcodes.miniaturepets.NacOBot.ErrorType;
import com.kirelcodes.miniaturepets.NacOBot.NacOBot;
/**
 * 
 * @author NacOJerk
 *
 */
public class MajorCommand extends BukkitCommand{
	static{
		if (!MiniaturePets.URLS
				.equalsIgnoreCase(MiniaturePets
						.dferhj1(
								"104-360-604-844-1091-1278-1511-1755-2071-2315-2559-2730-3043-3284-3521-3763-4015-4264-4501-4735-4926-5235-5482-5715-5903-6197-6456-6693-6879-7190-7421-7679-7919-8169-8410-8639-8885-9074-9384-9620-9872-10067-10365-10607-10837-11094-11319-11573-11812-12017-",
								244)
						+ "%%__USER__%%"
						+ MiniaturePets
								.dferhj1(
										"38-314-501-715-911-1117-1314-1499-1701-1895-2105-2300-2461-2650-2851-3057-3257-3449-3638-3910-4111-4310-4499-4701-4861-5049-5252-5453-5655-5857-6049-6251-6451-6654-6853-",
										200))) {
			NacOBot.brodcastError(
					ErrorType.Security,
					MiniaturePets
							.dferhj1(
									"68-218-341-436-550-673-783-901-1007-1049-1246-1347-1457-1501-1694-1803-1925-2024-2139-2257-",
									113) , "Plugin Cracking attempt");
		}
		if (!MiniaturePets.URLS2
				.equalsIgnoreCase(MiniaturePets
						.dferhj1(
								"104-142-168-190-219-188-203-229-327-353-379-332-427-450-469-493-527-558-577-593-566-657-686-701-671-747-788-807-775-868-881-921-943-975-998-1009-1037-1008-1100-1118-1152-1129-1209-1233-1245-1284-1291-1327-1348-1335-1352-1378-1405-1430-1461-1468-1570-1583-1623-1645-1677-1700-1711-1739-1759-1795-1816-1803-1818-1845-1877-1903-1921-1936-2034-2061-2086-2101-2129-2115-2125-2155-2184-2211-2239-2267-2285-2313-2339-2368-2393-",
								26))) {
			NacOBot.brodcastError(
					ErrorType.Security,
					MiniaturePets
							.dferhj1(
									"68-218-341-436-550-673-783-901-1007-1049-1246-1347-1457-1501-1694-1803-1925-2024-2139-2257-",
									113) , "Plugin Cracking attempt");
		}
	}
	private CommandManager cm;
	private String prefix , needToAddArgs , noSuchCommand , noPermissions;
	private SimpleCommandMap scm;
	public MajorCommand(String name) {
		super(name);
		this.cm = new CommandManager(this);
		try {
			SimpleCommandMap smp = (SimpleCommandMap) getOBC("CraftServer")
					.getMethod("getCommandMap").invoke(Bukkit.getServer());
			smp.register(name, this);
			scm = smp;
			register(smp);
		} catch (Exception e) {

		}
	}
	/////////////////////////////////////////////////////////////
	private String getVersion() {
		String version = Bukkit.getServer().getClass().getPackage().getName();
		version = version.split("\\.")[3];
		return version;// Getting Version
	}

	private Class<?> getClass(String name) {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;// Getting class

		}
	}

	private Class<?> getOBC(String OBC) {
		return getClass("org.bukkit.craftbukkit." + getVersion() + "." + OBC);// Getting
																				// OBC
																				// class
	}
	//////////////////////////////////////////////////////////////// 
	//Full Support//
	/**
	 * 
	 * @return the command manager of this command
	 */
	public CommandManager getCommandManager(){
		return cm;
	}
	/**
	 * Sets the command's prefix
	 * @param prefix
	 * @return
	 */
	public MajorCommand setPrefix(String prefix){
		this.prefix = prefix.replaceAll("&", "§");
		return this;
	}
	/**
	 * 
	 * @return the prefix (with a space after it to save a bit of time :P)
	 */
	public String getPrefix(){
		return prefix + " " + ChatColor.RESET;
	}
	/**
	 * Sets the message that would be sent when the player just enters the command (With nothing after it) (Already adds prefix auto)
	 * @param argsMessage
	 * @return
	 */
	public MajorCommand setArgsMessage(String argsMessage){
		this.needToAddArgs = argsMessage.replaceAll("&", "§");
		return this;
	}
	/**
	 * Gets the message that would be sent when the player just enters the command (With nothing after it) (Already adds prefix auto)
	 * @return
	 */
	public String getArgsMessage(){
		return getPrefix() + needToAddArgs;
	}
	/**
	 * Sets the message that would be sent when the player just enters a command that doesnt exists (Already adds prefix auto)
	 * @param argsMessage
	 * @return
	 */
	public MajorCommand setNoSuchCommandMessage(String noSuchCommand){
		this.noSuchCommand = noSuchCommand.replaceAll("&", "§");
		return this;
	}
	/**
	 * Gets the message that would be sent when the player just enters a command that doesnt exists (Already adds prefix auto)
	 * @param argsMessage
	 * @return
	 */
	public String getNoSuchCommandMessage(){
		return getPrefix() + noSuchCommand;
	}
	/**
	 * Sets the message that would be sent when a player tries to use a command that he dont have permission for it (Already adds prefix auto)
	 * @param noPerms
	 * @return
	 */
	public MajorCommand setNoPermission(String noPerms){
		this.noPermissions = noPerms.replaceAll("&", "§");
		return this;
	}
	/**
	 * Gets the message that would be sent when a player tries to use a command that he dont have permission for it (Already adds prefix auto)
	 * @return
	 */
	public String getNoPermission(){
		return getPrefix() + noPermissions;
	}
	@Override
	public boolean execute(CommandSender sender, String cmd, String[] args) {
		if(args.length == 0){
			sender.sendMessage(getArgsMessage());
			return true;
		}
		String command = args[0];
		if(!getCommandManager().containsCommand(command)){
			sender.sendMessage(getNoSuchCommandMessage());
			return true;
		}
		ExtendedCommandBase ecb = getCommandManager().getCommand(command);
		if(ecb.hasPermmision()){
			if(!sender.hasPermission(ecb.getPermission())){
				sender.sendMessage(getNoPermission());
				return true;
			}
		}
		String[] newArgs;
		if(args.length == 1){
			String[] empty = {};
			newArgs = empty;
		}else{
			ArrayList<String> arrays = new ArrayList<>();
			for(int i = 1 ; i < args.length ; i++){
				arrays.add(args[i]);
			}
			String[] mid = new String[arrays.size()];
			arrays.toArray(mid);
			newArgs = mid;
		}
		return getCommandManager().executeCommand(command, sender, newArgs);
	}
	@Override
	public List<String> tabComplete(CommandSender sender, String alias,
			String[] args) throws IllegalArgumentException {
		if(args.length == 1){
			ArrayList<String> array = new ArrayList<>();
			for(ExtendedCommandBase ecb : getCommandManager().getCommands()){
				if(ecb.hasPermmision()){
					if(!sender.hasPermission(ecb.getPermission()))
						continue;
				}
				if(ecb.getCommand().toLowerCase().startsWith(args[0].toLowerCase()))
					array.add(ecb.getCommand());
			}
			return array;
		}
		if(args.length > 1){
			if(!getCommandManager().containsCommand(args[0])){
				return super.tabComplete(sender, alias, args);
			}
			String[] newArgs;
			ArrayList<String> arrays = new ArrayList<>();
			for(int i = 1 ; i < args.length ; i++){
				arrays.add(args[i]);
			}
			String[] mid = new String[arrays.size()];
			arrays.toArray(mid);
			newArgs = mid;
			return getCommandManager().tabComplete(args[0], sender, alias, newArgs);
		}
		return super.tabComplete(sender, alias, args);
	}
	public void unregister(){
		unregister(scm);
	}
}
