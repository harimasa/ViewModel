package ru.matt.api;

import com.terraformersmc.modmenu.util.mod.Mod;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import static ru.matt.ViewModel.MOD_CONFIG;

@Config(name = "viewmodel")
public class ClothConfigConfig implements ConfigData {

    // Main Settings Scale and Positions

    @ConfigEntry.Category("Scale")
    @Comment("Affect Items?")
    @ConfigEntry.Gui.PrefixText
    public boolean enabled = true;

    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -0f, Max - 2f")
    @ConfigEntry.BoundedDiscrete(max = 2)
    @ConfigEntry.Gui.PrefixText
    public float scale = 1f;

    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.BoundedDiscrete(min = -3, max = 3)
    @ConfigEntry.Gui.PrefixText
    public float positionMainX = 0f;

    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.BoundedDiscrete(min = -3, max = 3)
    public float positionMainY = 0f;

    @ConfigEntry.Category("Scale")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.BoundedDiscrete(min = -3, max = 3)
    public float positionMainZ = 0f;

    // Main Hand Settings

    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    @ConfigEntry.Gui.PrefixText
    public float rotationMainX = 0f;

    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    public float rotationMainY = 0f;

    @ConfigEntry.Category("Main Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    public float rotationMainZ = 0f;

    // Offhand Settings

    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    @ConfigEntry.Gui.PrefixText
    public float rotationOffX = 0f;

    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    public float rotationOffY = 0f;

    @ConfigEntry.Category("Off Hand")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    public float rotationOffZ = 0f;

    // Arm Settings

    @ConfigEntry.Category("Arm Settings")
    @Comment("Affect Arm?")
    @ConfigEntry.Gui.PrefixText
    public boolean enabledArm = false;

    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = - 180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    @ConfigEntry.Gui.PrefixText
    public float rotationArmX = 0f;

    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    public float rotationArmY = 0f;

    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = - 180f, Max = 180f")
    @ConfigEntry.BoundedDiscrete(min = -180, max = 180)
    public float rotationArmZ = 0f;

    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.BoundedDiscrete(min = -3, max = 3)
    @ConfigEntry.Gui.PrefixText
    public float positionArmX = 0f;

    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.BoundedDiscrete(min = -3, max = 3)
    public float positionArmY = 0f;

    @ConfigEntry.Category("Arm Settings")
    @Comment("Recommended Min = -3f, Max = 3f")
    @ConfigEntry.BoundedDiscrete(min = -3, max = 3)
    public float positionArmZ = 0f;

    // Special OR BIG SPECIAL COMBO YEEEEAHHH
    // да я русский со мной БОГ!

    @ConfigEntry.Category("Special")
    @ConfigEntry.Gui.PrefixText
    public boolean enabledSpecial = false;

    @ConfigEntry.Category("Special")
    @ConfigEntry.Gui.PrefixText
    public boolean nohands = false;

    @ConfigEntry.Category("Special")
    public boolean hand1f = false;

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

    public static boolean enabled() {
        return MOD_CONFIG.enabled;
    }

    public static boolean enabledArm() {
        return MOD_CONFIG.enabledArm;
    }

    public static boolean enabledSpecial() {
        return MOD_CONFIG.enabledSpecial;
    }

    public static boolean nohands() {
        return MOD_CONFIG.nohands;
    }

    public static boolean hand1f() {
        return MOD_CONFIG.hand1f;
    }
}