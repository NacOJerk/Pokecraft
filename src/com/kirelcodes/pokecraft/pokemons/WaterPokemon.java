package com.kirelcodes.pokecraft.pokemons;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class WaterPokemon extends Pokemon {
	static {
		WaterPokemon.anchorType = EntityType.SQUID;
		WaterPokemon.anchorTypeName = "Squid";
		WaterPokemon.name = "waterPokemon";
	}

	public WaterPokemon(Location loc) {
		super(loc);
	}

}
