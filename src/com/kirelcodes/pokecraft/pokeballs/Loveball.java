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

public class Loveball extends Ball {
	static {
		rateBonus = 1;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/b6114db71f6e4de3274abe6fe2cc4568a052694cd9c53c62d1415b8f4a235628");
		editItem(item, ChatColor.RED + "Loveball", ChatColor.RED
				+ "Gotta catch them all!");
		ShapedRecipe recipe = new ShapedRecipe(item).shape("HDH" , "CBC" , "III")
				.setIngredient('D', Dyes.PINK.getMaterialData())
				.setIngredient('H', Dyes.WHITE.getMaterialData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT)
				.setIngredient('C', Material.CHEST);
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Loveball.class);
	}

	public Loveball(ItemStack item) {
		super(item);
	}

	public static boolean shouldCatch(Pokemon poke, Player p) {
		return Loveball.getCurrentCtachRate(poke, p) > 1;
	}

	protected static double getCurrentCtachRate(Pokemon poke, Player p) {
		Random rand = new Random();
		float curRateBonus = getRateBonus();
		// TODO: After adding pokemon selection, like in pixelmon, implement
		// this:
		/*
		 * if(poke.getGender()==PokeGender.MALE){
		 * if(playerCurrentPokemon.getGender()==PokeGender.FEMALE){ curRateBonus
		 * = 8; } } else if(poke.getGender()==PokeGender.FEMALE){
		 * if(playerCurrentPokemon.getGender()==PokeGender.MALE){ curRateBonus =
		 * 8; } }
		 */

		double rate = ((((3 * poke.getMaxHealth()) - (2 * poke
				.getCurrentHealth())) * (poke.getCatchRate()) * curRateBonus) / (3 * poke
				.getMaxHealth())) * poke.getStatus().getBonus();
		return (rate + ((rand.nextDouble() / 3) * 2));
	}

}
