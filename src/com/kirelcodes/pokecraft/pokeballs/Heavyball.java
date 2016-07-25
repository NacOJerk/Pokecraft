package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.ItemStackUtils.editItem;
import static com.kirelcodes.pokecraft.utils.ItemStackUtils.getSkull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.pokecraft.pokemons.Pokemon;
import com.kirelcodes.pokecraft.utils.Dyes;

public class Heavyball extends Ball {
	static {
		rateBonus = 1;
		ItemStack item = getSkull("http://textures.minecraft.net/texture/db296f75cb2df67a84e81b391c5c98df27b0cef6704e9d29b0a26caa57fff2d1");
		editItem(item, ChatColor.RED + "Heavyball", ChatColor.RED
				+ "Gotta catch them all!");
		ShapedRecipe recipe = new ShapedRecipe(item)
				.setIngredient('D', Dyes.GRAY.getMaterialData())
				.setIngredient('H', Dyes.CYAN.getMaterialData())
				.setIngredient('B', Material.STONE_BUTTON)
				.setIngredient('I', Material.IRON_INGOT).setIngredient('O', Material.OBSIDIAN)
				.setIngredient('C', Material.CHEST).shape("HDH").shape("CBC")
				.shape("III");
		Bukkit.addRecipe(recipe);
		PokeballManager.addPokeballType(item, Heavyball.class);
	}

	public Heavyball(ItemStack item) {
		super(item);
	}

	public static boolean shouldCatch(Pokemon poke, Player p) {
		return Heavyball.getCurrentCtachRate(poke, p) > 1;
	}

	protected static double getCurrentCtachRate(Pokemon poke, Player p) {
		Random rand = new Random();
		float curRateBonus = 0;
		//TODO: WHEN THOSE POKEMON EXIST, COMMENT OUT THERE PART
		List<Class<? extends Pokemon>> plus20 = new ArrayList<Class<? extends Pokemon>>();
		List<Class<? extends Pokemon>> plus30 = new ArrayList<Class<? extends Pokemon>>();
		List<Class<? extends Pokemon>> plus40 = new ArrayList<Class<? extends Pokemon>>();
		// -- PLUS 20 --
		//plus20.add(Camerupt.class);
		//plus20.add(Dragonite.class);
		//plus20.add(Gigalith.class);
		//plus20.add(Golem.class);
		//plus20.add(Gyarados.class);
		//plus20.add(Lapras.class);
		//plus20.add(Lugia.class);
		//plus20.add(Mamoswine.class);
		//plus20.add(Mantine.class);
		//plus20.add(Onix.class);
		//plus20.add(Rayquaza.class);
		//plus20.add(Regirock.class);
		//plus20.add(Registeel.class);
		//plus20.add(Rhyperior.class);
		// -- PLUS 30 --
		//plus30.add(Aggron.class);
		//plus30.add(Golurk.class);
		//plus30.add(Kyogre.class);
		//plus30.add(Steelix.class);
		//plus30.add(Torterra.class);
		//plus30.add(Wailord.class);
		// -- PLUS 40 --
		//plus30.add(Groudon.class);
		//plus30.add(Metagross.class);
		//plus30.add(Regigigas.class);
		//plus30.add(Snorlax.class);
		
		if(plus20.contains(poke.getClass())){
			curRateBonus = 20;
		}else if(plus30.contains(poke.getClass())){
			curRateBonus = 30;
		}else if(plus40.contains(poke.getClass())){
			curRateBonus = 40;
		}else{
			curRateBonus = -20;
		}
		
		double rate = ((((3 * poke.getMaxHealth()) - (2 * poke
				.getCurrentHealth())) * (poke.getCatchRate()) + curRateBonus) / (3 * poke
				.getMaxHealth())) * poke.getStatus().getBonus();
		return (rate + ((rand.nextDouble() / 3) * 2));
	}

}
