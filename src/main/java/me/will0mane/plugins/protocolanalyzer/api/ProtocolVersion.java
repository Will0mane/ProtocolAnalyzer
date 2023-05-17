package me.will0mane.plugins.protocolanalyzer.api;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public enum ProtocolVersion {

    VER_1_8(47, "1.8x"),
    VER_1_9(107, "1.9"),
    VER_1_9_1(108, "1.9.1"),
    VER_1_9_2(109, "1.9.2"),
    VER_1_9_3x(110, "1.9.3 / 1.9.4"),
    VER_1_10(210, "1.10x"),
    VER_1_11(315, "1.11"),
    VER_1_11_X(316, "1.11x"),
    VER_1_12(335, "1.12"),
    VER_1_12_1(338, "1.12.1"),
    VER_1_12_2(340, "1.12.2"),
    VER_1_13(393, "1.13"),
    VER_1_13_1(401, "1.13.1"),
    VER_1_13_2(404, "1.13.2"),
    VER_1_14(477, "1.14"),
    VER_1_14_1(480, "1.14.1"),
    VER_1_14_2(485, "1.14.2"),
    VER_1_14_3(490, "1.14.3"),
    VER_1_14_4(498, "1.14.4"),
    VER_1_15(573, "1.15"),
    VER_1_15_1(575, "1.15.1"),
    VER_1_15_2(578, "1.15.2"),
    VER_1_16(735, "1.16"),
    VER_1_16_1(736, "1.16.1"),
    VER_1_16_2(751, "1.16.2"),
    VER_1_16_3(753, "1.16.3"),
    VER_1_16_4(754, "1.16.4 / 1.16.5"),
    VER_1_17(755, "1.17"),
    VER_1_17_1(756, "1.17.1"),
    VER_1_18(757, "1.18 / 1.18.1"),
    VER_1_18_2(758, "1.18.2"),
    VER_1_19(759, "1.19"),
    VER_1_19_1(760, "1.19.1 / 1.19.2"),
    VER_1_19_3(761, "1.19.3"),
    VER_1_19_4(762, "1.19.4"),
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
