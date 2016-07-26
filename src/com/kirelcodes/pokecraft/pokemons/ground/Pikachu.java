package com.kirelcodes.pokecraft.pokemons.ground;

import java.io.IOException;

import org.bukkit.Location;

import com.kirelcodes.pokecraft.pokemons.GroundPokemon;
import com.kirelcodes.pokecraft.utils.ModelLoader;

public class Pikachu extends GroundPokemon {
	static {
		name = "Pikachu";
		try {
			model = ModelLoader.loadModelByName("Pikachu");
		} catch (IOException e) {
		}
	}

	public Pikachu(Location loc) {
		super(loc);
	}

}
