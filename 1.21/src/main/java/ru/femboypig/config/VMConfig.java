package ru.femboypig.config;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class VMConfig {

    // ITEMS

    @SerialEntry
    public boolean enable = false;

    @SerialEntry
    public float scale = 1f;

    @SerialEntry
    public float posX = 0f;

    @SerialEntry
    public float posY = 0f;

    @SerialEntry
    public float posZ = 0f;

    @SerialEntry
    public float rotMainX = 0f;

    @SerialEntry
    public float rotMainY = 0f;

    @SerialEntry
    public float rotMainZ = 0f;

    @SerialEntry
    public float rotOffX = 0f;

    @SerialEntry
    public float rotOffY = 0f;

    @SerialEntry
    public float rotOffZ = 0f;

    // ARM

    @SerialEntry
    public boolean enableArm = false;

    @SerialEntry
    public float posArmX = 0f;

    @SerialEntry
    public float posArmY = 0f;

    @SerialEntry
    public float posArmZ = 0f;

    @SerialEntry
    public float rotArmX = 0f;

    @SerialEntry
    public float rotArmY = 0f;

    @SerialEntry
    public float rotArmZ = 0f;
}
