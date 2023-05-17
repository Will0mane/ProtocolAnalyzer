package me.will0mane.plugins.protocolanalyzer;

import me.will0mane.plugins.protocolanalyzer.api.ProtocolVersion;
import me.will0mane.plugins.protocolanalyzer.api.manager.ProtocolManager;
import me.will0mane.plugins.protocolanalyzer.api.protocol.Protocol;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class ProtocolAnalyzer extends JavaPlugin {

    private static final ProtocolManager manager = new ProtocolManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Protocol getProtocol(Player player) {
        return getProtocolManager().getProtocol(player);
    }

    public static void cleanUp() {
        getProtocolManager().cleanUp();
    }

    public static ProtocolManager getProtocolManager() {
        return manager;
    }

    public ProtocolVersion getProtocolVersion(Player player) {
        return getProtocolManager().getVersion(getProtocol(player));
    }
}
