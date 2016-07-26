package com.kirelcodes.pokecraft.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.google.common.io.Files;
import com.kirelcodes.pokecraft.Pokecraft;

/**
 * 
 * @author DrPiggy
 *
 */
public class ModelLoader {
	
	/**
	 * Get a Model by its name. Retrieves it from the "models" folder nested in the jar.
	 * @param name Model name
	 * @return A file object of the model
	 * @throws IOException 
	 */
	public static File loadModelByName(String name) throws IOException{
		File tempDir = Files.createTempDir();
		File tempFile = new File(tempDir, name + ".mpet");
	    FileOutputStream out = new FileOutputStream(tempFile);
	    IOUtils.copy(Pokecraft.getInstance().getResource("models/"+name+".mpet"), out);
	    return tempFile;
	}

}
