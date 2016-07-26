package com.kirelcodes.pokecraft.pokemons;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class FlyingPokemon extends Pokemon{
	static{
		anchorType = EntityType.BAT;
		anchorTypeName = "Bat";
		name = "flyingPokemon";
	}
	public FlyingPokemon(Location loc) {
		super(loc);
	}

}
