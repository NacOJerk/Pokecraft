package com.kirelcodes.pokecraft.pathfinder;

import java.util.ArrayList;

import org.bukkit.scheduler.BukkitRunnable;

import com.kirelcodes.pokecraft.Pokecraft;
import com.kirelcodes.pokecraft.pokemons.Pokemon;

public class PathManager extends BukkitRunnable {
	private ArrayList<BasicPathfinder> paths;
	private Pokemon pokemon;

	public PathManager(Pokemon pokemon) {
		this.pokemon = pokemon;
		paths = new ArrayList<>();
		runTaskTimer(Pokecraft.getInstance(), 0L, 1L);
	}

	public void addPathfinder(BasicPathfinder path) {
		paths.add(path);
	}
	
	public void clear(){
		paths.clear();
	}

	@Override
	public void run() {
		if (pokemon.isDead()) {
			cancel();
			return;
		}
		for (BasicPathfinder path : paths) {
			if (path.isRunning()) {
				if (!path.keepWorking()) {
					path.setRunning(false);
					continue;
				}
				path.updateTask();
				path.afterTask();
				if (!path.canBeInterrupted()) {
					return;
				}
				continue;
			}
			if (!path.shouldStart())
				continue;
			path.setRunning(true);
			path.onStart();
		}
	}

}
