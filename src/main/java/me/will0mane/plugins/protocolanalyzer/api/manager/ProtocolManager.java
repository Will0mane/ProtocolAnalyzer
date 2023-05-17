package me.will0mane.plugins.protocolanalyzer.api.manager;

import me.will0mane.plugins.protocolanalyzer.api.ProtocolVersion;
import me.will0mane.plugins.protocolanalyzer.api.protocol.Protocol;
import org.bukkit.entity.Player;

import java.util.*;

public class ProtocolManager {

    private final Map<Player, Protocol> protocolMap = new HashMap<>();

    public void registerProtocol(Player player){
        protocolMap.put(player, new Protocol(player));
    }

    public Protocol getProtocol(Player player) {
        return protocolMap.getOrDefault(player, null);
    }

    public ProtocolVersion getVersion(Protocol protocol) {
        return ProtocolVersion.match(protocol.versionInt());
    }

    public void unregisterProtocol(Player player) {
        protocolMap.remove(player);
    }

    public void cleanUp() {
        Set<Player> toRemove = new HashSet<>();
        protocolMap.forEach((player, protocol) ->  {
            if(!player.isOnline()) toRemove.add(player);
        });
        toRemove.forEach(this::unregisterProtocol);
    }
}
