package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.pokecraft.utils.Dyes;

public class Ultraball extends Ball {
	static {
		rateBonus = 2;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/3d85c96efaefef11a1a35b117ca2f231c696e4e693b73a1bae77221607011e");
		editItem(item, ChatColor.RED + "Ultraball", ChatColor.RED
				+ "Gotta catch them all!");
		ShapedRecipe recipe = new ShapedRecipe(item)
				.setIngredient('D', Dyes.BLACK.getMaterialData())
				.setIngredient('B', Dyes.YELLOW.getMaterialData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT).setIngredient('G', Material.GOLD_INGOT)
				.setIngredient('C', Material.CHEST).shape("BDB").shape("CBC")
				.shape("GIG");
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Ultraball.class);
	}

	public Ultraball(ItemStack item) {
		super(item);
	}
}
