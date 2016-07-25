package com.kirelcodes.pokecraft.utils;

import org.bukkit.DyeColor;
import org.bukkit.material.Dye;

public enum Dyes {
	
	WHITE(DyeColor.WHITE), 
	ORANGE(DyeColor.ORANGE), 
	MAGENTA(DyeColor.MAGENTA), 
	LIGHT_BLUE(DyeColor.LIGHT_BLUE), 
	YELLOW(DyeColor.YELLOW), 
	LIME(DyeColor.LIME), 
	PINK(DyeColor.PINK), 
	GRAY(DyeColor.GRAY), 
	SILVER(DyeColor.SILVER), 
	CYAN(DyeColor.CYAN), 
	PURPLE(DyeColor.PURPLE), 
	BLUE(DyeColor.BLUE), 
	BROWN(DyeColor.BROWN), 
	GREEN(DyeColor.GREEN), 
	RED(DyeColor.RED), 
	BLACK(DyeColor.BLACK);
	
	private DyeColor color;

	Dyes(DyeColor color) {
		this.color = color;
	}

	public Dye getMaterialData() {
		Dye dye = new Dye();
		dye.setColor(this.color);
		return dye;
	}
}
