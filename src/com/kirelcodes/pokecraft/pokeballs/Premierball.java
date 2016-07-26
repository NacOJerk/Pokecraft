package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.pokecraft.utils.Dyes;

//TODO: Make the premier ball make red particles in the throw mechanism
public class Premierball extends Ball {
	static{
		rateBonus = 1;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/db5c8d73fc7a143baca4a18bdcc705176762fa010e313b14d81f8b5ebdc4c47");
		editItem(item, ChatColor.RED + "Premierball", ChatColor.RED + "Gotta catch them all!");
		ShapedRecipe recipe = new ShapedRecipe(item).shape("HDH" , "CBC" ,"III")
		.setIngredient('D', Dyes.RED.getMaterialData()).setIngredient('H', Dyes.WHITE.getMaterialData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT).setIngredient('C', Material.CHEST);
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Premierball.class);
	}
	
	public Premierball(ItemStack item) {
		super(item);
	}
}
