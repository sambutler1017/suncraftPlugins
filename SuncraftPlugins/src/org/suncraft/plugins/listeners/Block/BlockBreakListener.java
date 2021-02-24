package org.suncraft.plugins.listeners.Block;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.suncraft.plugins.Main;
import org.suncraft.plugins.listeners.utils.Utils;

/**
 * Broadcast a message when a player breaks a block
 * 
 * @author Sam Butler
 * @since Feb 22, 2021
 */
public class BlockBreakListener implements Listener, CommandExecutor {
    private Main plugin;

    private boolean blockBreakEnabled = false;

    public BlockBreakListener(Main plugin) {
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
                blockBreakEnabled = true;
                Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("breakBlock_enabled_message")));
            } else if (args[0].toLowerCase().equals("disable")) {
                blockBreakEnabled = false;
                Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("breakBlock_disabled_message")));
            } else {
                sender.sendMessage("Not a valid argument!");
            }
        }
        return true;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent be) {
        if (blockBreakEnabled) {
            Player p = be.getPlayer();
            Location l = p.getLocation();
            Location targetLocation = new Location(p.getWorld(), l.getX(), 200, l.getZ());

            p.teleport(targetLocation);

            Bukkit.broadcastMessage(Utils
                    .chat(plugin.getConfig().getString("breakBlock_message").replace("<player>", p.getDisplayName())
                            .replace("<block>", be.getBlock().getBlockData().getMaterial().toString())));
        }
    }
}
