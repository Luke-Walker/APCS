package me.lukewalker.sandbox.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader {

	// CREDIT TO SOMEONE ON THE INTERNET FOR A LOT OF HELP ON THE PLUGIN LOADER CLASS
	
	private PluginLoader() {}
	private static PluginLoader INSTANCE = null;
	public static PluginLoader getInstance() {
		if (INSTANCE == null) INSTANCE = new PluginLoader();
		return INSTANCE;
	}
	
	public ArrayList<Plugin> plugins = null;
	public ArrayList<Plugin> enabled = null;
	public ArrayList<Plugin> disabled = new ArrayList<>();
	
	public Class<?> loadClass(String dir, String config) throws ClassNotFoundException, IOException {
		return loadClass(new File(dir), config);
	}
	
	public Class<?> loadClass(File dir, String config) throws IOException, ClassNotFoundException {
		final JarFile jf = new JarFile(dir);
		final JarEntry je = jf.getJarEntry(config);
		
		final BufferedReader br = new BufferedReader(new InputStreamReader(jf.getInputStream(je)));
		
		final HashMap<String, String> data = new HashMap<>();
		
		String in;
		while ((in = br.readLine()) != null) {
			if (in.isEmpty() || in.startsWith("#"))
				continue;
			final String[] split = in.split(" ");
			data.put(split[0], split[1]);
		}
		
		jf.close();
		
		return Class.forName(data.get("Main"), true, new URLClassLoader(new URL[] {dir.toURI().toURL()}));
	}
	
	public Class<?>[] loadDirectory(String dir, String config) throws ClassNotFoundException, IOException {
		return loadDirectory(new File(dir), config);
	}
	
	// TODO: MAKE SURE ONLY .JAR FILES ARE BEING LOADED
	public Class<?>[] loadDirectory(File dir, String config) throws ClassNotFoundException, IOException {
		final File[] files = dir.listFiles();
		for (File f : files) System.out.println(f.getName());
		
		final Class<?>[] classes = new Class<?>[files.length];
		
		for (int i = 0; i < files.length; i++)
			classes[i] = loadClass(files[i], config);
			
		return classes;
	}
	
	public Plugin initAsPlugin(Class<?> group) throws InstantiationException, IllegalAccessException {
		return (Plugin) group.newInstance();
	}
	
	public Plugin[] initAsPlugin(Class<?>[] group) throws InstantiationException, IllegalAccessException {
		final Plugin[] plugins = new Plugin[group.length];
		
		for (int i = 0; i < group.length; i++)
			plugins[i] = initAsPlugin(group[i]);
			
		return plugins;
	}
	
	public void initPlugins() {
		Plugin[] plugins = null;
		try {
			plugins = initAsPlugin(loadDirectory("plugins", "config.cfg"));
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		this.plugins = new ArrayList<>(Arrays.asList(plugins));
		this.enabled = new ArrayList<>(Arrays.asList(plugins));
		
		for (Plugin plugin : enabled) {
			plugin.load();
		}
	}
}
