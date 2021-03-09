package org.suncraft.plugins;

import org.bukkit.plugin.java.JavaPlugin;
import org.suncraft.plugins.listeners.Block.BlockBreakListener;
import org.suncraft.plugins.listeners.Block.BlockBreakTabCompletion;
import org.suncraft.plugins.listeners.Mobs.MobHostileListender;
import org.suncraft.plugins.listeners.Mobs.MobHostileTabCompletion;
import org.suncraft.plugins.listeners.Mobs.MobSpawnListener;
import org.suncraft.plugins.listeners.Player.ChatListener;
import org.suncraft.plugins.listeners.Player.DeathListener;
import org.suncraft.plugins.listeners.Player.JoinListener;
import org.suncraft.plugins.listeners.Player.LeaveListener;

/**
 * Main class to handle all the commands and listeners
 * 
 * @author Sam Butler
 * @since Feb 20, 2021
 */
public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();

		commandInit();
		listenerInit();
	}

	/**
	 * Helper method to Intialize all the commands
	 * 
	 * @since Feb 23, 2021
	 */
	private void commandInit() {
		getCommand("blockBreakTP").setExecutor(new BlockBreakListener(this));
		getCommand("blockBreakTP").setTabCompleter(new BlockBreakTabCompletion());

		getCommand("hostileMobs").setExecutor(new MobHostileListender(this));
		getCommand("hostileMobs").setTabCompleter(new MobHostileTabCompletion());
	}

	/**
	 * Helper method to Initialize all the listeners
	 * 
	 * @since Feb 23, 2021
	 */
	private void listenerInit() {
		new JoinListener(this);
		new LeaveListener(this);
		new ChatListener(this);
		new DeathListener(this);
		new MobSpawnListener(this);
	}
}
