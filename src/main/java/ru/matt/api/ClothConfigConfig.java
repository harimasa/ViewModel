package ru.matt.api;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import static ru.matt.ViewModel.MOD_CONFIG;

@Config(name = "viewmodel")
public class ClothConfigConfig implements ConfigData {

    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -0.1f, Max - 1.5f")
    public float scale = 1f;
    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    public float positionMainX = 0f;
    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    public float positionMainY = 0f;
    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    public float positionMainZ = 0f;

    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationMainX = 0f;
    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationMainY = 0f;
    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationMainZ = 0f;

    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationOffX = 0f;
    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationOffY = 0f;
    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationOffZ = 0f;

    public static float scale() {
        return MOD_CONFIG.scale;
    }

    public static float positionMainX() {
        return MOD_CONFIG.positionMainX;
    }

    public static float positionMainY() {
        return MOD_CONFIG.positionMainY;
    }

    public static float positionMainZ() {
        return MOD_CONFIG.positionMainZ;
    }

    public static float rotationMainX() {
        return MOD_CONFIG.rotationMainX;
    }

    public static float rotationMainY() {
        return MOD_CONFIG.rotationMainY;
    }

    public static float rotationMainZ() {
        return MOD_CONFIG.rotationMainZ;
    }

    public static float rotationOffX() {
        return MOD_CONFIG.rotationOffX;
    }

    public static float rotationOffY() {
        return MOD_CONFIG.rotationOffY;
    }

    public static float rotationOffZ() {
        return MOD_CONFIG.rotationOffZ;
    }
}