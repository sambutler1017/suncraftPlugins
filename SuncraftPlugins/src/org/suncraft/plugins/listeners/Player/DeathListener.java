package org.suncraft.plugins.listeners.Player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.suncraft.plugins.Main;
import org.suncraft.plugins.listeners.utils.Utils;

@SuppressWarnings("unused")
public class DeathListener implements Listener {
    private Main plugin;

    public DeathListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();

        String name = String.format("%s %s", Utils.getRole(p).displayName(), p.getDisplayName());
        e.setDeathMessage(Utils.chat(e.getDeathMessage().replace(p.getDisplayName(), name + "&7")));
    }
}
