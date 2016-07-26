package com.kirelcodes.pokecraft.pokemons.ground;

import org.bukkit.Location;

import com.kirelcodes.pokecraft.Pokecraft;
import com.kirelcodes.pokecraft.pokemons.GroundPokemon;

public class Pikachu extends GroundPokemon{
	static{
		name = "Pikachu";
		model = Pokecraft.getInstance().getResource("/models/Pikachu.mpet");
	}
	public Pikachu(Location loc) {
		super(loc);
	}

}
