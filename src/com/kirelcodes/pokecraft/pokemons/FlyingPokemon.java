package com.kirelcodes.pokecraft.pokemons;

import static com.kirelcodes.pokecraft.utils.NMSClassInteracter.getNMS;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

public class FlyingPokemon extends Pokemon{
	private static Object boundingBoxBat;
	static{
		FlyingPokemon.anchorType = EntityType.GHAST;
		FlyingPokemon.anchorTypeName = "Ghast";
		FlyingPokemon.name = "flyingPokemon";
		World w = Bukkit.getServer().getWorlds().get(0);
		try{
		Object bat = getNMS("EntityBat").getConstructor(getNMS("World")).newInstance(w.getClass().getMethod("getHandle").invoke(w));
		Field f = getNMS("Entity").getDeclaredField("boundingBox");
		f.setAccessible(true);
		boundingBoxBat = f.get(bat);
		f.setAccessible(false);
		System.out.println(boundingBoxBat);
		}catch(Exception e){e.printStackTrace();}
		
	}
	public FlyingPokemon(Location loc) {
		super(loc);
		try{
		getModelMob().getNMSHandle().getClass().getMethod("setSize", float.class , float.class).invoke(getModelMob().getNMSHandle(), 0.5f, 0.5f);
		Object nmsGhast = getModelMob().getNMSHandle();
		Field f = getNMS("Entity").getDeclaredField("boundingBox");
		f.setAccessible(true);
		f.set(nmsGhast, boundingBoxBat);
		f.setAccessible(false);
		getModelMob().getNMSHandle().getClass().getMethod("setSize", float.class , float.class).invoke(getModelMob().getNMSHandle(), 0.5f, 0.5f);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
