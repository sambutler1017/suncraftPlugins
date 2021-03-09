package org.suncraft.plugins.listeners.Mobs;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.suncraft.plugins.Main;

@SuppressWarnings("unused")
public class MobSpawnListener implements Listener {
    private Main plugin;

    public MobSpawnListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    //@EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event) {
    }
}
