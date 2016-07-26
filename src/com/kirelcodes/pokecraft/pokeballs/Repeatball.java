package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.pokecraft.pokemons.Pokemon;
import com.kirelcodes.pokecraft.utils.Dyes;

public class Repeatball extends Ball {
	static {
		rateBonus = 1;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/17b2d4b7c2d73a9f7876e6b2e0a3b180c00348f97d6ffb56159b614ae33");
		editItem(item, ChatColor.RED + "Repeatball", ChatColor.RED
				+ "Gotta catch them all!");
		ShapedRecipe recipe = new ShapedRecipe(item).shape("HDH" , "CBC" , "III")
				.setIngredient('D', Dyes.ORANGE.getMaterialData())
				.setIngredient('H', Dyes.RED.getMaterialData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT)
				.setIngredient('C', Material.CHEST);
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Repeatball.class);
	}

	public Repeatball(ItemStack item) {
		super(item);
	}

	public static boolean shouldCatch(Pokemon poke, Player p) {
		return Repeatball.getCurrentCtachRate(poke, p) > 1;
	}

	protected static double getCurrentCtachRate(Pokemon poke, Player p) {
		Random rand = new Random();
		float curRateBonus = getRateBonus();
		// TODO: After implementing the pokdex, and pokemon history, add this:
		/*
		 * if(pokedex.contains(poke.getClass()){
		 * 	curRateBonus = 3;
		 * }
		 */

		double rate = ((((3 * poke.getMaxHealth()) - (2 * poke
				.getCurrentHealth())) * (poke.getCatchRate()) * curRateBonus) / (3 * poke
				.getMaxHealth())) * poke.getStatus().getBonus();
		return (rate + ((rand.nextDouble() / 3) * 2));
	}

}
