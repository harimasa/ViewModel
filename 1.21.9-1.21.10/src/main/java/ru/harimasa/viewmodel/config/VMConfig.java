package ru.harimasa.viewmodel.config;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class VMConfig {
    // General
    @SerialEntry
    public boolean enable = false;

    // Main Hand
    @SerialEntry
    public float mainScale = 1f;

    // Main Hand Position
    @SerialEntry public float posMainX = 0f;
    @SerialEntry public float posMainY = 0f;
    @SerialEntry public float posMainZ = 0f;

    // Main Hand Rotation
    @SerialEntry public float rotMainX = 0f;
    @SerialEntry public float rotMainY = 0f;
    @SerialEntry public float rotMainZ = 0f;

    // Off Hand
    @SerialEntry
    public float offScale = 1f;

    // Off Hand Position
    @SerialEntry public float posOffX = 0f;
    @SerialEntry public float posOffY = 0f;
    @SerialEntry public float posOffZ = 0f;

    // Off Hand Rotation
    @SerialEntry public float rotOffX = 0f;
    @SerialEntry public float rotOffY = 0f;
    @SerialEntry public float rotOffZ = 0f;

    @SerialEntry
    public boolean affectArm = false;

    // Arm Position
    @SerialEntry public float posArmX = 0f;
    @SerialEntry public float posArmY = 0f;
    @SerialEntry public float posArmZ = 0f;

    // Arm Rotation
    @SerialEntry public float rotArmX = 0f;
    @SerialEntry public float rotArmY = 0f;
    @SerialEntry public float rotArmZ = 0f;

    // Swing Animation
    @SerialEntry
    public boolean animEnable = false;

    @SerialEntry public boolean slowAnim = false;
    @SerialEntry public int slowAnimValue = 12;

    @SerialEntry
    public Templates enumOption = Templates.Default;

    public enum Templates {
        Default, Alternative
    }
}