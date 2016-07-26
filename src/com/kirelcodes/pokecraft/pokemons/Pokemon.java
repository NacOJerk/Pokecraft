package com.kirelcodes.pokecraft.pokemons;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import com.kirelcodes.miniaturepets.api.pets.APIMob;
import com.kirelcodes.miniaturepets.api.pets.APIMobContainer;
import com.kirelcodes.pokecraft.pokemons.enums.PokeGender;
import com.kirelcodes.pokecraft.pokemons.enums.PokeState;
import com.kirelcodes.pokecraft.pokemons.enums.PokeType;

public class Pokemon {

	private PokeType type;
	private PokeGender gender;
	private float exp;
	private int level;
	private PokeState state;
	/**
	 * GAL FILL WAT IS CATCHRATE
	 */
	protected static float catchRate = 0;
	/**
	 * The pokemon max health
	 */
	protected static double maxHealth = 40;
	/**
	 * The navigator mob type
	 */
	protected static EntityType anchorType = EntityType.CHICKEN;
	/**
	 * The navigator mob type name
	 */
	protected static String anchorTypeName = "Chicken";
	/**
	 * The speed of the pokemon
	 */
	protected static double speed = 0.2;
	/**
	 * The pokemon model file
	 */
	protected static File model = null;
	/**
	 * The pokemon name
	 */
	protected static String name = "pokemon";
	private static APIMobContainer mobContainer = null;
	private APIMob anchorMob = null;

	public Pokemon(Location loc) {
		if (mobContainer == null) {
			mobContainer = new APIMobContainer(model, name, maxHealth, speed,
					anchorType, anchorTypeName);
		}
		anchorMob = mobContainer.spawnMob(loc);
	}

	public static double getMaxHealth() {
		return maxHealth;
	}

	public double getCurrentHealth() {
		return getModelMob().getHealth();
	}

	public PokeType getType() {
		return type;
	}

	public PokeGender getGender() {
		return gender;
	}

	public float getExp() {
		return exp;
	}

	public int getLevel() {
		return level;
	}

	public static float getCatchRate() {
		return catchRate;
	}

	public PokeState getStatus() {
		return state;
	}

	public APIMob getModelMob() {
		return anchorMob;
	}

	public Location getLocation() {
		return getModelMob().getLocation();
	}

	public String getName() {
		return getModelMob().getName();
	}

	public void setHealth(double health) {
		getModelMob().setHealth(health);
	}
	public void teleport(Location loc) {
		getModelMob().teleport(loc);
	}

	public void teleport(Entity e) {
		teleport(e.getLocation());
	}

	public boolean setTargetLocation(Location loc) throws Exception{
		return getModelMob().setTargetLocation(loc);
	}
	
	public Location getTargetLocation(){
		return getModelMob().getTargetLocation();
	}
	
	public boolean onTargetLocation(){
		return getModelMob().onTargetLocation();
	}
}
