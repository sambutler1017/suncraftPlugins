package org.suncraft.plugins.listeners.Mobs;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.suncraft.plugins.Main;
import org.suncraft.plugins.utils.Utils;

public class MobHostileListender implements Listener, CommandExecutor {
    private Main plugin;
    private boolean disableHostileMobs = false;

    public MobHostileListender(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("Not enough arguments!");
            return false;
        } else if (args.length > 1) {
            sender.sendMessage("To Many Arguments!");
            return false;
        } else {
            if (args[0].toLowerCase().equals("enable")) {
                disableHostileMobs = true;
                Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("hostileMobs_enabled_message")));
            } else if (args[0].toLowerCase().equals("disable")) {
                disableHostileMobs = false;
                Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("hostileMobs_disabled_message")));
            } else {
                sender.sendMessage("Not a valid argument!");
            }
        }
        return true;
    }

    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        if(disableHostileMobs) {
            if(event.getTarget() instanceof Player) {
                if(event.getEntity() instanceof Monster) {
                    event.setCancelled(true);
                }
            }
        }

    }
}
