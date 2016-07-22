package com.kirelcodes.pokecraft;

import org.bukkit.plugin.java.JavaPlugin;

public class Pokecraft extends JavaPlugin{
	private static Pokecraft instance = null;
	@Override
	public void onEnable() {
		instance = this;
	}
	
	public static Pokecraft getInstance() {
		return instance;
	}
}
