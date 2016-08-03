package com.kirelcodes.pokecraft.pokemons.air;

import org.bukkit.Location;

import com.kirelcodes.pokecraft.pokemons.FlyingPokemon;
import com.kirelcodes.pokecraft.pokemons.enums.PokeType;
import com.kirelcodes.pokecraft.utils.ModelLoader;

public class Voltorb extends FlyingPokemon {
	static {
		Voltorb.name = "Voltorb";
		try {
			Voltorb.model = ModelLoader.loadModelByName("Voltorb");
		} catch (Exception e) {
		}
		Voltorb.type = PokeType.ELECTRIC;
		Voltorb.speed = 0.2;
		Voltorb.maxHealth = 40;
		Voltorb.catchRate = 190;
	}

	public Voltorb(Location loc) {
		super(loc);
	}

}
