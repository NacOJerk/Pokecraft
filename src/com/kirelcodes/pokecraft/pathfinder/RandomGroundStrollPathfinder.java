package com.kirelcodes.pokecraft.pathfinder;

import java.util.Random;

import org.bukkit.Location;

import com.kirelcodes.pokecraft.pokemons.GroundPokemon;

public class RandomGroundStrollPathfinder extends BasicPathfinder{
	private int clock;
	private Random rand;
	private GroundPokemon pokemon;
	
	public RandomGroundStrollPathfinder(GroundPokemon pokemon) {
		this.pokemon = pokemon;
	}
	@Override
	public void onStart() {
		clock = 0;
		rand = new Random();
	}
	@Override
	public boolean shouldStart() {
		return true;
	}

	@Override
	public void afterTask() {
		clock++;
	}
	@Override
	public void updateTask() {
		if((clock % 100) != 0)
			return;
		int x1 = rand.nextInt(11) - 5;
		int x = pokemon.getLocation().clone().add(x1, 0, 0).getBlockX();
		int z1 = rand.nextInt(11) - 5;
		int z = pokemon.getLocation().clone().add(0, 0, z1).getBlockZ();
		int y = pokemon.getLocation().getWorld().getHighestBlockYAt(x, z);
		Location loc = new Location(pokemon.getLocation().getWorld(), x, y, z);
		try {
			pokemon.setTargetLocation(loc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
