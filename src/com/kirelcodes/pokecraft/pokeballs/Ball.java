package com.kirelcodes.pokecraft.pokeballs;

import static com.kirelcodes.pokecraft.utils.NBTRW.getNBTBoolean;
import static com.kirelcodes.pokecraft.utils.NBTRW.getNBTString;
import static com.kirelcodes.pokecraft.utils.NBTRW.writeNBT;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.kirelcodes.pokecraft.pokemons.Pokemon;
import com.kirelcodes.pokecraft.pokemons.enums.PokeGender;
import com.kirelcodes.pokecraft.pokemons.enums.PokeState;
import com.kirelcodes.pokecraft.pokemons.enums.PokeType;
import com.kirelcodes.pokecraft.serializer.DynamicSerializer;
public abstract class Ball {

	/**
	 * Constant per-ball catch rate bonus
	 */
	protected static float rateBonus;
	/**
	 * The item containing the ball information
	 */
	protected ItemStack item;

	public Ball(ItemStack item){
		this.item = item;
	}
	
	/**
	 * Should the given player ctach the given pokemon
	 * @param poke The pokemon which the player is trying to catch
	 * @param p The player who throws the ball
	 * @return If the ball succeeded to catch the given pokemon
	 */
	public static boolean shouldCatch(Pokemon poke, Player p) {
		return getCurrentCatchRate(poke, p)>1;
	}
	
	/**
	 * Retrieves the catch rate based on the pokemon and ball factor, with added light randomness
	 * @param poke
	 * @param p
	 * @return A double from 0 to 2. Gets effected by many factors. above 1 is a catch.
	 */
	protected static double getCurrentCatchRate(Pokemon poke, Player p){
		Random rand = new Random();
		double rate = ((((3 * poke.getMaxHealth()) - (2 * poke
				.getCurrentHealth())) * (poke.getCatchRate()) * getRateBonus()) / (3 * poke
				.getMaxHealth())) * poke.getStatus().getBonus();
		return (rate + ((rand.nextDouble()/3)*2));
	}

	/**
	 * 
	 * @return Ball catch rate bonus
	 */
	public static float getRateBonus() {
		return rateBonus;
	}
	
	/**
	 * 
	 * @return Does the ball contains a pokemon
	 */
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
	
	/**
	 * Insert a pokemon to the ball nms
	 * @param poke The pokemon to insert
	 */
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

	/**
	 * Spawns the pokemon inside of the ball at the given location, and returns an instance of it
	 * @param loc Location to spawn the pokemon
	 * @return The spawned pokemon
	 */
	public Pokemon getPokemon(Location loc){
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
			Pokemon poke = clazz.getConstructor(Location.class).newInstance(loc);
			poke.setEXP(exp);
			poke.setHealth(HP);
			poke.setGender(gender);
			poke.setLevel(level);
			poke.setState(status);
			return poke;
		} catch (Exception e) {}
		return null; 
	}

}