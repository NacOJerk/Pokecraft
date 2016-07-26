package com.kirelcodes.pokecraft.pokemons;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

import com.kirelcodes.pokecraft.pathfinder.RandomGroundStrollPathfinder;

public class GroundPokemon extends Pokemon{
	static{
		anchorType = EntityType.ZOMBIE;
		anchorTypeName = "Zombie";
		name = "groundPokemon";
	}
	public GroundPokemon(Location loc) {
		super(loc);
		((Zombie)getModelMob().getNavigator()).setBaby(true);
		addPathfinder(new RandomGroundStrollPathfinder(this));
	}

}
