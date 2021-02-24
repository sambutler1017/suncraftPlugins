package org.suncraft.plugins.listeners.Player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.suncraft.plugins.Main;
import org.suncraft.plugins.listeners.utils.Utils;

public class ChatListener implements Listener {
    private Main plugin;

    public ChatListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        String name = String.format("%s %s", Utils.getRole(p).displayName(), p.getDisplayName());

        e.setFormat(Utils.chat(plugin.getConfig().getString("chat_message").replace("<player>", name)
                .replace("<message>", e.getMessage())));
    }
}
