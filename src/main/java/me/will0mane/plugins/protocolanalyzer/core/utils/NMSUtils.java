package me.will0mane.plugins.protocolanalyzer.core.utils;

import lombok.SneakyThrows;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
public class NMSUtils {

    private NMSUtils(){}

    public static int getProtocolVersion(Player player) {
        Object networkManager = getNetworkManager(player);
        return getIntFieldOn(networkManager,"protocolVersion");
    }

    public static Object getNetworkManager(Player player) {
        Object playerConnection = getPlayerConnection(player);
        return getFieldOn(playerConnection, "a");
    }

    private static Object getPlayerConnection(Player player) {
        Object entityPlayer = invokeMethodOn(player, "getHandle");
        return getFieldOn(entityPlayer, "b");
    }

    @SneakyThrows
    public static Object getFieldOn(Object object, String name) {
        return getField(object,name).get(object);
    }

    @SneakyThrows
    public static Field getField(Object object, String name) {
        Field field = object.getClass().getField(name);
        field.setAccessible(true);
        return field;
    }

    @SneakyThrows
    public static int getIntFieldOn(Object object, String name) {
        return getField(object,name).getInt(object);
    }

    @SneakyThrows
    public static Object invokeMethodOn(Object object, String method, Object... params) {
        return object.getClass().getDeclaredMethod(method).invoke(params);
    }

}
