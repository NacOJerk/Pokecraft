package com.kirelcodes.pokecraft.pokemons;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class WaterPokemon extends Pokemon {
	static {
		anchorType = EntityType.SQUID;
		anchorTypeName = "Squid";
		name = "waterPokemon";
	}

	public WaterPokemon(Location loc) {
		super(loc);
	}

}
