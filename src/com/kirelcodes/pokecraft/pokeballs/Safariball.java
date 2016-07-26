package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.pokecraft.pokemons.Pokemon;
import com.kirelcodes.pokecraft.utils.Dyes;

public class Safariball extends Ball {
	static {
		rateBonus = 1;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/72eac5f499e312165364f1af152660cd3f18d94e2ed55b27dafe8cf842a794f1");
		editItem(item, ChatColor.RED + "Safariball", ChatColor.RED
				+ "Gotta catch them all!");
		ShapedRecipe recipe = new ShapedRecipe(item).shape("HDH" , "CBC" , "III")
				.setIngredient('D', Dyes.ORANGE.getMaterialData())
				.setIngredient('H', Dyes.GREEN.getMaterialData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT)
				.setIngredient('C', Material.CHEST);
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Safariball.class);
	}

	public Safariball(ItemStack item) {
		super(item);
	}

	public static boolean shouldCatch(Pokemon poke, Player p) {
		return Safariball.getCurrentCtachRate(poke, p) > 1;
	}

	protected static double getCurrentCtachRate(Pokemon poke, Player p) {
		Random rand = new Random();
		float curRateBonus = getRateBonus();
		if (p.getWorld().getBiome(p.getLocation().getBlockX(),
				p.getLocation().getBlockY()) == Biome.SAVANNA
				|| p.getWorld().getBiome(p.getLocation().getBlockX(),
						p.getLocation().getBlockY()) == Biome.SAVANNA_ROCK
				|| p.getWorld().getBiome(p.getLocation().getBlockX(),
						p.getLocation().getBlockY()) == Biome.PLAINS)
			curRateBonus = 1.5f;
		double rate = ((((3 * poke.getMaxHealth()) - (2 * poke
				.getCurrentHealth())) * (poke.getCatchRate()) * curRateBonus) / (3 * poke
				.getMaxHealth())) * poke.getStatus().getBonus();
		return (rate + ((rand.nextDouble() / 3) * 2));
	}

}
