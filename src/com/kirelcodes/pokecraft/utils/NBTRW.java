package com.kirelcodes.pokecraft.utils;

import org.bukkit.inventory.ItemStack;

/**
 * @author NacOJerk
 */
public class NBTRW {
	//NBTRW Stands for : NBT Read and Write 
	/**
	 * @param is Item which you want to modify its nms
	 * @param Path the nms "Name"(IDK)
	 * @param write what you want to be written
	 * @return A modified version
	 * @throws Exception
	 * @author NacOJerk
	 */
	public static ItemStack writeNBT(ItemStack is , String Path , String write) throws Exception{
		ItemStack result = is;
		Object NMSisO = NMSClassInteracter.asNMSCopy(result);
		Class<?> NMSisC = NMSisO.getClass();
		Object NMSnbtO = NMSisC.getMethod("getTag").invoke(NMSisO);
		Class<?> NMSnbtC = NMSnbtO.getClass();
		NMSnbtC.getMethod("setString", String.class , String.class).invoke(NMSnbtO, Path , write);
		NMSisC.getMethod("setTag", NMSnbtC).invoke(NMSisO, NMSnbtO);
		result =NMSClassInteracter.asBukkitCopy(NMSisO);
		return result;
	}
	/**
	 * @param is Item which you want to modify its nms
	 * @param Path the nms "Name"(IDK)
	 * @param write what you want to be written
	 * @return A modified version
	 * @throws Exception
	 * @author NacOJerk
	 */
	public static ItemStack writeNBT(ItemStack is , String Path , int write) throws Exception{
		ItemStack result = is;
		Object NMSisO = NMSClassInteracter.asNMSCopy(result);
		Class<?> NMSisC = NMSisO.getClass();
		Object NMSnbtO = NMSisC.getMethod("getTag").invoke(NMSisO);
		Class<?> NMSnbtC = NMSnbtO.getClass();
		NMSnbtC.getMethod("setInt", String.class , int.class).invoke(NMSnbtO, Path , write);
		NMSisC.getMethod("setTag", NMSnbtC).invoke(NMSisO, NMSnbtO);
		result =NMSClassInteracter.asBukkitCopy(NMSisO);
		return result;
	}
	/**
	 * @param is Item which you want to modify its nms
	 * @param Path the nms "Name"(IDK)
	 * @param write what you want to be written
	 * @return A modified version
	 * @throws Exception
	 * @author NacOJerk
	 */
	public static ItemStack writeNBT(ItemStack is , String Path , boolean write) throws Exception{
		ItemStack result = is;
		Object NMSisO = NMSClassInteracter.asNMSCopy(result);
		Class<?> NMSisC = NMSisO.getClass();
		Object NMSnbtO = NMSisC.getMethod("getTag").invoke(NMSisO);
		Class<?> NMSnbtC = NMSnbtO.getClass();
		NMSnbtC.getMethod("setBoolean", String.class , boolean.class).invoke(NMSnbtO, Path , write);
		NMSisC.getMethod("setTag", NMSnbtC).invoke(NMSisO, NMSnbtO);
		result =NMSClassInteracter.asBukkitCopy(NMSisO);
		return result;
	}
	
	public static String getNBTString(ItemStack is , String Path)throws Exception{
		Object NMSisO = NMSClassInteracter.asNMSCopy(is);
		Class<?> NMSisC = NMSisO.getClass();
		Object NMSnbtO = NMSisC.getMethod("getTag").invoke(NMSisO);
		Class<?> NMSnbtC = NMSnbtO.getClass();
		String result = (String) NMSnbtC.getMethod("getString", String.class).invoke(NMSnbtO, Path);
		return result;
	}
	public static int getNBTInt(ItemStack is , String Path)throws Exception{
		Object NMSisO = NMSClassInteracter.asNMSCopy(is);
		Class<?> NMSisC = NMSisO.getClass();
		Object NMSnbtO = NMSisC.getMethod("getTag").invoke(NMSisO);
		Class<?> NMSnbtC = NMSnbtO.getClass();
		int result = (int) NMSnbtC.getMethod("getInt", String.class).invoke(NMSnbtO, Path);
		return result;
	}
	public static boolean getNBTBoolean(ItemStack is , String Path)throws Exception{
		Object NMSisO = NMSClassInteracter.asNMSCopy(is);
		Class<?> NMSisC = NMSisO.getClass();
		Object NMSnbtO = NMSisC.getMethod("getTag").invoke(NMSisO);
		Class<?> NMSnbtC = NMSnbtO.getClass();
		boolean result = (boolean) NMSnbtC.getMethod("getBoolean", String.class).invoke(NMSnbtO, Path);
		return result;
	}
	public static boolean containsNBTTag(ItemStack is , String Path)throws Exception{
		Object NMSisO = NMSClassInteracter.asNMSCopy(is);
		Class<?> NMSisC = NMSisO.getClass();
		Object NMSnbtO = NMSisC.getMethod("getTag").invoke(NMSisO);
		return (boolean) NMSnbtO.getClass().getMethod("hasKey", String.class).invoke(NMSnbtO, Path);
	}
	
}
