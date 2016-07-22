package com.kirelcodes.pokecraft.serializer;

import java.util.HashMap;
import java.util.Map;

public class DynamicSerializer {
	
	private Map<String, Object> serMap;
	
	public DynamicSerializer(){
		serMap = new HashMap<String, Object>();
	}
	
	public void addObject(String key, Object obj){
		serMap.put(key, obj);
	}
	
	public void removeObject(String key){
		serMap.remove(key);
	}
	
	public Object getObject(String key){
		return serMap.get(key);
	}
	
	public String serialize(){
		String str = "";
		for(String key : serMap.keySet()){
			str += key + ":" + serMap.get(key) + ";";
		}
		return str;
	}
	
	public void deserialize(String str){
		char[] chars = str.toCharArray();
		String removed = "";
		for (int i = 0; i < chars.length; i++) {
			if(i+1==chars.length)
				break;
			removed += chars[i];
		}
		String[] combos = removed.split(";");
		for(String combo : combos){
			String[] splitCombo = combo.split(":");
			addObject(splitCombo[0], splitCombo[1]);
		}
	}

}
