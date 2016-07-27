package com.kirelcodes.pokecraft.pokemons.air;

import org.bukkit.Location;

import com.kirelcodes.pokecraft.pokemons.FlyingPokemon;
import com.kirelcodes.pokecraft.pokemons.enums.PokeType;
import com.kirelcodes.pokecraft.utils.ModelLoader;

public class Voltorb extends FlyingPokemon {
	static {
		name = "Voltorb";
		try {
			model = ModelLoader.loadModelByName("Voltorb");
		} catch (Exception e) {
		}
		type = PokeType.ELECTRIC;
		speed = 0.2;
		maxHealth = 40;
		catchRate = 190;

	}

	public Voltorb(Location loc) {
		super(loc);
	}

}
