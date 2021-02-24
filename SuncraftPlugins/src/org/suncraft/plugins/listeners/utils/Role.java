package org.suncraft.plugins.listeners.utils;

import java.util.Arrays;
import java.util.List;

public enum Role {
    GUEST("group.guest", "&f[&7Guest&f]&7"), MEMBER("group.member", "&f[&eMember&F]&e"),
    MOD("group.moderator", "&f[&bMod&f]&b"), ADMIN("group.admin", "&6[&9Admin&6]&9"),
    COOWNER("group.coowner", "&6[&4Co-Owner&6]&4"), OWNER("group.owner", "&6[&cOwner&6]&c");

    private String permission;
    private String displayName;

    Role(String permission, String displayname) {
        this.permission = permission;
        this.displayName = displayname;
    }

    public String permission() {
        return permission;
    }

    public String displayName() {
        return displayName;
    }

    public static Role getEnumFromString(String str) {
        List<Role> values = Arrays.asList(Role.values());
        for (Role value : values) {
            if (str.contains(value.permission()))
                return value;
        }
        return GUEST;
    }
}
