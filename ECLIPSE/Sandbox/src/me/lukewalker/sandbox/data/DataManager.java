package me.lukewalker.sandbox.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DataManager {

	private DataManager() {}
	private static DataManager INSTANCE = null;
	public static DataManager getInstance() {
		if (INSTANCE == null) INSTANCE = new DataManager();
		return INSTANCE;
	}
	
	public static final File PATH = new File(System.getProperty("user.dir"));
	
	public static final int CONFIG_VERSION = 1;
	public static final String CONFIG_PATH = PATH.getAbsolutePath() + File.separator + "data" + File.separator + "config_" + CONFIG_VERSION + ".cfg";
	
	public HashMap<String, String> settings = new HashMap<>();
	
	public void loadSettings() throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(CONFIG_PATH));
		
		String in;
		while ((in = br.readLine()) != null) {
			if (in.isEmpty() || in.startsWith("#"))
				continue;
			final String[] split = in.split(" ");
			settings.put(split[0], split[1]);
		}
		
		br.close();
	}
	
	public String getSetting(String setting) {
		return settings.get(setting);
	}
	
	public void setSetting(String setting, String value) {
		settings.put(setting, value);
		try {
			saveSettings();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveSettings() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(CONFIG_PATH));
		
		for (String key : settings.keySet())
			bw.write(key + " " + settings.get(key) + "\n");
		
		bw.close();
	}
	
	public void createDir(File path, String name) {
		new File(path.getAbsolutePath() + File.separator + name).mkdir();
	}
	
	public void createFile(File path, String name, String[] lines) {
		try {
			new File(path.getAbsolutePath() + File.separator + name).createNewFile();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		if (lines != null) {
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(CONFIG_PATH));
				
				for (String line : lines)
					bw.write(line + "\n");
		
				bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void createFiles() {
		createDir(PATH, "data");
		createFile(new File(PATH + File.separator + "data"), "config_" + CONFIG_VERSION + ".cfg", new String[] {
				"Main null"
		});
		createDir(PATH, "plugins");
	}
}
