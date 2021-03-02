package org.suncraft.plugins.listeners.Player;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.suncraft.plugins.Main;
import org.suncraft.plugins.listeners.utils.Utils;

/**
 * Join Listener class that outputs a join message in the chat
 * 
 * @author Sam Butler
 * @since Feb 22, 2021
 */
public class JoinListener implements Listener {
	private Main plugin;

	public JoinListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		p.getStatistic(Statistic.PLAYER_KILLS);

		String name = String.format("%s %s", Utils.getRole(p).displayName(), p.getDisplayName());
		p.setPlayerListName(Utils.chat(plugin.getConfig().getString("tablist").replace("<player>", name)));

		if (!p.hasPlayedBefore()) {
			e.setJoinMessage(Utils.chat(plugin.getConfig().getString("firstJoin_message").replace("<player>", name)));
		} else {
			e.setJoinMessage(Utils.chat(plugin.getConfig().getString("join_message").replace("<player>", name)));
		}
	}
}
