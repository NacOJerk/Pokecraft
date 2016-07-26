package com.kirelcodes.pokecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.kirelcodes.pokecraft.pokeballs.Greatball;
import com.kirelcodes.pokecraft.pokeballs.Heavyball;
import com.kirelcodes.pokecraft.pokeballs.Loveball;
import com.kirelcodes.pokecraft.pokeballs.Masterball;
import com.kirelcodes.pokecraft.pokeballs.Pokeball;
import com.kirelcodes.pokecraft.pokeballs.Premierball;
import com.kirelcodes.pokecraft.pokeballs.Repeatball;
import com.kirelcodes.pokecraft.pokeballs.Safariball;
import com.kirelcodes.pokecraft.pokeballs.Ultraball;
import com.kirelcodes.pokecraft.pokemons.ground.Pikachu;

public class Pokecraft extends JavaPlugin{
	private static Pokecraft instance = null;
	@Override
	public void onEnable() {
		instance = this;
		loadPokeballs();
		for(Player p : Bukkit.getOnlinePlayers())
			new Pikachu(p.getLocation().add(2 , 0 ,2));
	}
	
	public void loadPokeballs(){
		new Greatball(null);
		new Heavyball(null);
		new Loveball(null);
		new Masterball(null);
		new Pokeball(null);
		new Premierball(null);
		new Repeatball(null);
		new Safariball(null);
		new Ultraball(null);
	}
	
	public static Pokecraft getInstance() {
		return instance;
	}
}
