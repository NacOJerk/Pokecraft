package com.kirelcodes.pokecraft.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.kirelcodes.pokecraft.pokeballs.Ball;
import com.kirelcodes.pokecraft.pokeballs.PokeballManager;
import com.kirelcodes.pokecraft.utils.NBTRW;


public class CraftinListener implements Listener{
	public CraftinListener(Plugin p){
		Bukkit.getPluginManager().registerEvents(this, p);
	}
	@EventHandler
	public void craftItem(CraftItemEvent e){
		Class<? extends Ball> clazz = null;
		if((clazz = PokeballManager.getFromItem(e.getCurrentItem())) == null)
			return;
		try {
			ItemStack item = NBTRW.writeNBT(e.getCurrentItem(), "pokeball-type", clazz.getName());
			e.setCurrentItem(item);
		} catch (Exception e1) {
			e.getInventory().getViewers().get(0).sendMessage(ChatColor.RED + "There has been a problem craftin your pokeball");
			return;
		}
	}
}
