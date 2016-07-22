package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
@SuppressWarnings("deprecation")
public class Pokeball extends Ball {
	static{
		rateBonus = 1;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/8deb47d47c28a6a43fc5b8d0fa46b2defbac9cbd5ab34480325a2459be110f4");
		editItem(item, ChatColor.RED + "Pokeball", ChatColor.RED + "Im a red ball !");
		ShapedRecipe recipe = new ShapedRecipe(item)
				.setIngredient('D', Material.INK_SACK,
						DyeColor.RED.getDyeData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT).shape("DDD")
				.shape(" B ").shape("III");
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Pokeball.class);
	}
	
	public Pokeball(ItemStack item) {
		super(item);
	}
}
