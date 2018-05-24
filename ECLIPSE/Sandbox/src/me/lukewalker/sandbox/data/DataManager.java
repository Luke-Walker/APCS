package me.lukewalker.sandbox.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;

public class DataManager {

	private DataManager() {}
	private static DataManager INSTANCE = null;
	public static DataManager getInstance() {
		if (INSTANCE == null) INSTANCE = new DataManager();
		return INSTANCE;
	}
	
	private static final int VERSION = 1;
	
	public File path = null;
	
	public HashMap<String, String> settings = new HashMap<>();
	
	public void setDataLocation(File path) {
		this.path = path;
		setSetting("Path", path.getPath());
	}
	
	public void loadSettings() throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/settings_" + VERSION + ".cfg")));
		
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
		saveSettings();
	}
	
	public void saveSettings() {
		try {
			FileWriter fw;
			try {
				fw = new FileWriter(new File(getClass().getResource("/settings_" + VERSION + ".cfg").toURI()));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (String key : settings.keySet()) {
				fw.write(key + " " + settings.get(key) + "\n");
			}
			
			fw.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void createDir(File path, String name) {
		new File(path.getAbsolutePath() + File.separator + name).mkdir();
	}
	
	public void createFile(File path, String name) {
		try {
			new File(path.getAbsolutePath() + name).createNewFile();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void createFiles() {
		createDir(path, "plugins");
	}
}
