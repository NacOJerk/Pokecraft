package com.kirelcodes.pokecraft.pokeballs;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Pokeball extends Ball {

	public Pokeball(ItemStack item) {
		super(item);
		this.rateBonus = 1;
	}
	
	public ShapedRecipe getRecipe() {
		@SuppressWarnings("deprecation")
		ShapedRecipe recipe = new ShapedRecipe()
				.setIngredient('D', Material.INK_SACK,
						DyeColor.RED.getDyeData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT).shape("DDD")
				.shape(" B ").shape("III");
		return recipe;
	}
}
