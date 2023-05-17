package me.will0mane.plugins.protocolanalyzer.api.protocol;

import me.will0mane.plugins.protocolanalyzer.core.utils.NMSUtils;
import org.bukkit.entity.Player;

public class Protocol {

    private final int versionInt;

    public Protocol(Player player) {
        versionInt = NMSUtils.getProtocolVersion(player);
    }

    public int versionInt() {
        return versionInt;
    }
}
