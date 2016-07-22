package com.kirelcodes.pokecraft.pokeballs;

import java.util.Random;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.pokecraft.Pokecraft;
import com.kirelcodes.pokecraft.pokemons.Pokemon;
import com.kirelcodes.pokecraft.pokemons.enums.PokeGender;
import com.kirelcodes.pokecraft.pokemons.enums.PokeState;
import com.kirelcodes.pokecraft.pokemons.enums.PokeType;
import com.kirelcodes.pokecraft.serializer.DynamicSerializer;

import static com.kirelcodes.pokecraft.utils.NBTRW.*;

public abstract class Ball {

	protected static float rateBonus;
	protected ItemStack item;

	public Ball(ItemStack item){
		this.item = item;
	}
	
	public static boolean shouldCatch(Pokemon poke) {
		return getCurrentCtachRate(poke)>1;
	}
	
	protected static double getCurrentCtachRate(Pokemon poke){
		Random rand = new Random();
		double rate = ((((3 * poke.getMaxHealth()) - (2 * poke
				.getCurrentHealth())) * (poke.getCatchRate()) * getRateBonus()) / (3 * poke
				.getMaxHealth())) * poke.getStatus().getBonus();
		return (rate + ((rand.nextDouble()/3)*2));
	}

	public static float getRateBonus() {
		return rateBonus;
	}
	
	public abstract ShapedRecipe getRecipe();
	
	public boolean containsPokemon(){
		try {
			return getNBTBoolean(item, "containsPokemon");
		} catch (Exception e) {
			try {
				writeNBT(item, "containsPokemon", false);
			} catch (Exception e1) {}
			return false;
		}
	}
	
	public void addPokemon(Pokemon poke){
		DynamicSerializer ser = new DynamicSerializer();
		ser.addObject("HP", poke.getCurrentHealth());
		ser.addObject("exp", poke.getExp());
		ser.addObject("level", poke.getLevel());
		ser.addObject("gender", poke.getGender().name());
		ser.addObject("status", poke.getStatus().name());
		ser.addObject("type", poke.getType().name());
		ser.addObject("class", poke.getClass().getName());
		try {
			writeNBT(item, "pokemon", ser.serialize());
			writeNBT(item, "containsPokemon", true);
		} catch (Exception e) {}
	}

	public Pokemon getPokemon(){
		DynamicSerializer ser = new DynamicSerializer();
		try {
			ser.deserialize(getNBTString(item, "pokemon"));
			float HP = (float) ser.getObject("HP");
			float exp = (float) ser.getObject("exp");
			int level = (int) ser.getObject("level");
			PokeGender gender = PokeGender.valueOf((String) ser.getObject("gender"));
			PokeState status = PokeState.valueOf((String)ser.getObject("status"));
			PokeType type = PokeType.valueOf((String)ser.getObject("type")); 
			Class<? extends Pokemon> clazz = (Class<? extends Pokemon>) Class.forName((String)ser.getObject("class")); 
		} catch (Exception e) {}
		return null; 
	}

}