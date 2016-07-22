package com.kirelcodes.pokecraft.pokemons;

import com.kirelcodes.pokecraft.pokemons.enums.PokeGender;
import com.kirelcodes.pokecraft.pokemons.enums.PokeState;
import com.kirelcodes.pokecraft.pokemons.enums.PokeType;

public class Pokemon {
	
	private float currentHealth;
	private PokeType type;
	private PokeGender gender;
	private float exp;
	private int level;
	private PokeState state;
	
	@Deprecated
	public static double getMaxHealth() {
		return 0;
	}

	@Deprecated
	public float getCurrentHealth() {
		return currentHealth;
	}

	@Deprecated
	public PokeType getType() {
		return type;
	}

	@Deprecated
	public PokeGender getGender() {
		return gender;
	}

	@Deprecated
	public float getExp() {
		return exp;
	}

	@Deprecated
	public int getLevel() {
		return level;
	}
	
	@Deprecated
	public static float getCatchRate() {
		return 0;
	}
	
	@Deprecated
	public PokeState getStatus(){
		return state;
	}
	
}
