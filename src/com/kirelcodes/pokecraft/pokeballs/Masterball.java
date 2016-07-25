package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.kirelcodes.pokecraft.pokemons.Pokemon;

public class Masterball extends Ball {
	static {
		ItemStack item = getSkull("http://textures.minecraft.net/texture/1879e64fd2e2d15d1b7e47ae40fa528fc72086a312d6a6ed3f7e552af9d5");
		editItem(item, ChatColor.GOLD + "Masterball", ChatColor.RED
				+ "Gotta catch them all!");
		PokeballManager.addPokeballType(item, Masterball.class);
	}

	public Masterball(ItemStack item) {
		super(item);
	}
	
	public static boolean shouldCatch(Pokemon poke, Player p){
		return true;
	}
}
