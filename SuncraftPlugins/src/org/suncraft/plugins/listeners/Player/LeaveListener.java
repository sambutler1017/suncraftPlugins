package org.suncraft.plugins.listeners.Player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.suncraft.plugins.Main;
import org.suncraft.plugins.listeners.utils.Utils;

/**
 * Join Listener class that outputs a join message in the chat
 * 
 * @author Sam Butler
 * @since Feb 22, 2021
 */
public class LeaveListener implements Listener {
    private Main plugin;

    public LeaveListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        String name = String.format("%s %s", Utils.getRole(p).displayName(), p.getDisplayName());
        e.setQuitMessage(Utils.chat(plugin.getConfig().getString("quit_message").replace("<player>", name)));
    }
}
