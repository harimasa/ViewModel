package ru.matt.api;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import static ru.matt.ViewModel.MOD_CONFIG;

@Config(name = "viewmodel")
public class ClothConfigConfig implements ConfigData {

    // Main Settings Scale and Positions

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -0.1f, Max - 1.5f")
    @ConfigEntry.Gui.PrefixText
    public float scale = 1f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.Gui.PrefixText
    public float positionMainX = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    public float positionMainY = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    public float positionMainZ = 0f;

    // Main Hand Settings

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.Gui.PrefixText
    public float rotationMainX = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationMainY = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationMainZ = 0f;

    // Off Hand Settings

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.Gui.PrefixText
    public float rotationOffX = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationOffY = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationOffZ = 0f;

    // Arm Settings

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = - 180f, Max = 180f")
    @ConfigEntry.Gui.PrefixText
    public float rotationArmX = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -180f, Max = 180f")
    public float rotationArmY = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = - 180f, Max = 180f")
    public float rotationArmZ = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.Gui.PrefixText
    public float positionArmX = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -3f, Max = 3f")
    public float positionArmY = 0f;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -3f, Max = 3f")
    public float positionArmZ = 0f;



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

    public static float rotationArmX() {
        return MOD_CONFIG.rotationArmX;
    }
    public static float rotationArmY() {
        return MOD_CONFIG.rotationArmY;
    }

    public static float rotationArmZ() {
        return MOD_CONFIG.rotationArmZ;
    }

    public static float positionArmX() {
        return MOD_CONFIG.positionArmX;
    }

    public static float positionArmY() {
        return MOD_CONFIG.positionArmY;
    }

    public static float positionArmZ() {
        return MOD_CONFIG.positionArmZ;
    }
}