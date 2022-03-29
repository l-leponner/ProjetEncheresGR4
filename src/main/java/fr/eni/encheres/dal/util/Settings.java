/**
 * 
 */
package fr.eni.encheres.dal.util;

import java.util.Properties;

/**
 * Classe en charge de 
 * @author lleponner2022
 * @date 28 mars 2022
 */
public class Settings {
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}
