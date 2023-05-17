package me.will0mane.plugins.protocolanalyzer.api;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public enum ProtocolVersion {

    VER_1_8(47, "1.8x"),
    ;

    private final int versionInt;
    private final String minecraftVersion;

    ProtocolVersion(int versionInt, String minecraftVersion) {
        this.versionInt = versionInt;
        this.minecraftVersion = minecraftVersion;
    }

    public int getVersionInt() {
        return versionInt;
    }

    public String getMinecraftVersion() {
        return minecraftVersion;
    }

    public static final Map<Integer, ProtocolVersion> versions = new HashMap<>();
    static {
        for (ProtocolVersion value : values()) {
            versions.put(value.getVersionInt(), value);
        }
    }

    public static ProtocolVersion match(int ver) {
        return versions.getOrDefault(ver, null);
    }

}
