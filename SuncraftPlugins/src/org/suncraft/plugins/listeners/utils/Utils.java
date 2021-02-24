package org.suncraft.plugins.listeners.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static Role getRole(Player p) {
        for (Role r : Role.values()) {
            if(p.hasPermission(r.permission())) {
                return r;
            }
        }
        return Role.GUEST;
    }
}
