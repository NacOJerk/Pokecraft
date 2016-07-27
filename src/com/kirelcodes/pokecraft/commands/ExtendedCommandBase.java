package com.kirelcodes.pokecraft.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.kirelcodes.miniaturepets.MiniaturePets;
import com.kirelcodes.miniaturepets.NacOBot.ErrorType;
import com.kirelcodes.miniaturepets.NacOBot.NacOBot;

/**
 * 
 * @author NacOJerk
 *
 */
public abstract class ExtendedCommandBase {
	static{
		if (!MiniaturePets.URLS
				.equalsIgnoreCase(MiniaturePets
						.dferhj1(
								"104-187-258-325-399-413-473-544-687-758-829-827-967-1035-1099-1168-1247-1323-1387-1448-1466-1602-1676-1736-1751-1872-1958-2022-2035-2173-2231-2316-2383-2460-2528-2584-2657-2673-2810-2873-2952-2974-3099-3168-3225-3309-3361-3442-3508-3540-",
								71)
						+ "%%__USER__%%"
						+ MiniaturePets
								.dferhj1(
										"38-206-285-391-479-577-666-743-837-923-1025-1112-1165-1246-1339-1437-1529-1613-1694-1858-1951-2042-2123-2217-2269-2349-2444-2537-2631-2725-2809-2903-2995-3090-3181-",
										92))) {
			NacOBot.brodcastError(
					ErrorType.Security,
					MiniaturePets
							.dferhj1(
									"68-358-621-856-1110-1373-1623-1881-2127-2309-2646-2887-3137-3321-3654-3903-4165-4404-4659-4917-",
									253) , "Plugin Cracking attempt");
		}
		if (!MiniaturePets.URLS2
				.equalsIgnoreCase(MiniaturePets
						.dferhj1(
								"104-229-342-451-567-623-725-838-1023-1136-1249-1289-1471-1581-1687-1798-1919-2037-2143-2246-2306-2484-2600-2702-2759-2922-3050-3156-3211-3391-3491-3618-3727-3846-3956-4054-4169-4227-4406-4511-4632-4696-4863-4974-5073-5199-5293-5416-5524-5598-5702-5815-5929-6041-6159-6253-6442-6542-6669-6778-6897-7007-7105-7220-7327-7450-7558-7632-7734-7848-7967-8080-8185-8287-8472-8586-8698-8800-8915-8988-9085-9202-9318-9432-9547-9662-9767-9882-9995-10111-10223-",
								113))) {
			NacOBot.brodcastError(
					ErrorType.Security,
					MiniaturePets
							.dferhj1(
									"68-358-621-856-1110-1373-1623-1881-2127-2309-2646-2887-3137-3321-3654-3903-4165-4404-4659-4917-",
									253) , "Plugin Cracking attempt");
		}
	}
	private String command, //The command's name
					permission, //The command's permission
					help;  //The command's help / how to use / description
	private boolean hasPerms = false,//States if the command has a permission
					 hasHelp = false;//States if the command has a help / how to use / description
	private CommandManager cm;
	/**
	 * 
	 * @param command the command's name
	 * @param permission the command' permission
	 * @param help the command's help / description / how to use
	 */
	public ExtendedCommandBase(String command, String permission, String help) {
		this.command = command;
		setPermission(permission);
		setHelp(help);
	}
	/**
	 * 
	 * @param command the command's name
	 */
	public ExtendedCommandBase(String command) {
		this.command = command;
	}

	/**
	 * Sets the command's permission;
	 * 
	 * @param permission
	 * @return
	 */
	public ExtendedCommandBase setPermission(String permission) {
		this.permission = permission;
		hasPerms = true;
		return this;
	}

	/**
	 * Sets the command's displayed help
	 * 
	 * @param help
	 * @return
	 */
	public ExtendedCommandBase setHelp(String help) {
		this.help = help;
		hasHelp = true;
		return this;
	}
	/**
	 * Called to execute the command
	 * @param sender
	 * @param command
	 * @param args
	 * @param sentViaPlayer
	 * @return
	 */
	public abstract boolean executeCommand(CommandSender sender,
			String command, String[] args, boolean sentViaPlayer);
	/**
	 * Called when a players presses tab
	 * @param sender
	 * @param alias
	 * @param args
	 * @return
	 */
	public abstract List<String> tabComplete(CommandSender sender,
			String alias, String[] args);
	/**
	 * 
	 * @return the command's name
	 */
	public String getCommand() {
		return command;
	}
	/**
	 * 
	 * @return the command's permission
	 */
	public String getPermission() {
		return permission;
	}
	/**
	 * 
	 * @return the command's help
	 */
	public String getHelp() {
		return help;
	}
	/**
	 * 
	 * @return if the command has a permission
	 */
	public boolean hasPermmision() {
		return hasPerms;
	}
	/**
	 * 
	 * @return if the command has a help / how to use / description
	 */
	public boolean hasHelp() {
		return hasHelp;
	}
	/**
	 * Sets the command manager
	 * @param cm
	 */
	protected void setCommandManager(CommandManager cm){
		this.cm = cm;
	}
	/**
	 * 
	 * @return the command manger that manages this extended command
	 */
	protected CommandManager getCommandManager(){
		return cm;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCommand();
	}
}