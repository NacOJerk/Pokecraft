package com.kirelcodes.pokecraft.pokeballs;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.inventory.ItemStack;

import com.kirelcodes.pokecraft.pokemons.Pokemon;
import com.kirelcodes.pokecraft.utils.NBTRW;

public class PokeballManager {
	private static HashMap<ItemStack, Class<? extends Ball>> pokeballTypes = new HashMap<>();

	public static void addPokeballType(ItemStack item,
			Class<? extends Ball> clazz) {
		pokeballTypes.put(item, clazz);
	}

	public static Class<? extends Ball> getFromItem(ItemStack item) {
		for (Entry<ItemStack, Class<? extends Ball>> entry : pokeballTypes
				.entrySet()) {
			if (!entry.getKey().isSimilar(item))
				continue;
			return entry.getValue();
		}
		return null;
	}

	public static boolean isPokeball(ItemStack item) {
		try {
			return NBTRW.containsNBTTag(item, "pokeball-type");
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean canCatch(ItemStack item, Pokemon poke) {
		if (!isPokeball(item))
			return false;
		try {
			String classPath = NBTRW.getNBTString(item, "pokeball-type");
			@SuppressWarnings("unchecked")
			Class<? extends Ball> clazz = (Class<? extends Ball>) Class
					.forName(classPath);
			if (clazz == null)
				return false;
			return (boolean) clazz.getMethod("shouldCatch", Pokemon.class)
					.invoke(null, poke);
		} catch (Exception e) {
			return false;
		}
	}
}
