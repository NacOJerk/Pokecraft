package com.kirelcodes.pokecraft.pokemons.ground;

import java.io.IOException;

import org.bukkit.Location;

import com.kirelcodes.pokecraft.pokemons.GroundPokemon;
import com.kirelcodes.pokecraft.pokemons.enums.PokeType;
import com.kirelcodes.pokecraft.utils.ModelLoader;

public class Pikachu extends GroundPokemon {
	static {
		Pikachu.name = "Pikachu";
		try {
			Pikachu.model = ModelLoader.loadModelByName("Pikachu");
		} catch (IOException e) {
		}
		Pikachu.type = PokeType.ELECTRIC;
		Pikachu.speed = 0.16;
		Pikachu.maxHealth = 35;
		Pikachu.catchRate = 190;
	}

	public Pikachu(Location loc) {
		super(loc);
	}

}
