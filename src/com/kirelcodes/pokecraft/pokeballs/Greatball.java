package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.pokecraft.utils.Dyes;

public class Greatball extends Ball {
	static {
		rateBonus = 1.5f;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/ecfaf610275f433a34e5317573ce1f9a0f667ce10cdf1d06c9eba5d9cb57047");
		editItem(item, ChatColor.RED + "Greatball", ChatColor.RED
				+ "Gotta catch them all!");
		ShapedRecipe recipe = new ShapedRecipe(item).shape("BDB" , "CBC" , "IGI")
				.setIngredient('D', Dyes.RED.getMaterialData())
				.setIngredient('B', Dyes.BLUE.getMaterialData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT).setIngredient('G', Material.GOLD_INGOT)
				.setIngredient('C', Material.CHEST);
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Greatball.class);
	}

	public Greatball(ItemStack item) {
		super(item);
	}
}
