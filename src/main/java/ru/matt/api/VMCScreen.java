package ru.matt.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import ru.matt.ViewModel;

import java.lang.reflect.Modifier;
import java.nio.file.Files;

public class VMCScreen {
    public static final transient Gson GSON = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

    // Enabled?
    public static boolean enabled = true;

    // Main Settings Scale and Positions
    public static float scale = 0.30985916f;
    public static float positionMainX = 0.5f;
    public static float positionMainY = 0.5f;
    public static float positionMainZ = 0.5f;

    // Main Hand Rotations
    public static float rotationMainX = 0.5f;
    public static float rotationMainY = 0.5f;
    public static float rotationMainZ = 0.5f;

    // Offhand Rotations
    public static float rotationOffX = 0.5f;
    public static float rotationOffY = 0.5f;
    public static float rotationOffZ = 0.5f;

    // Arm Settings

    // Enabled Arm Settings?
    public static boolean enabledArm = false;
    // Rotations Arm
    public static float rotationArmX = 0.5f;
    public static float rotationArmY = 0.5f;
    public static float rotationArmZ = 0.5f;

    // Positions Arm
    public static float positionArmX = 0.5f;
    public static float positionArmY = 0.5f;
    public static float positionArmZ = 0.5f;

    // BigSpecial Settings

        // Enabled BigSpecial settings
    public static boolean enabledSpecial = false;

        // Enabled No Hands
    public static boolean enabledNoHands = false;

        // Enabled Hands In F1
    public static boolean enabledHandsF1 = false;

    // Logarithm
    public static transient float scaleLog;
    public static transient float positionLogIX;
    public static transient float positionLogIY;
    public static transient float positionLogIZ;
    public static transient float rotationLogIX;
    public static transient float rotationLogIY;
    public static transient float rotationLogIZ;
    public static transient float rotationLogOffIX;
    public static transient float rotationLogOffIY;
    public static transient float rotationLogOffIZ;
    public static transient float positionLogAX;
    public static transient float positionLogAY;
    public static transient float positionLogAZ;
    public static transient float rotationLogAX;
    public static transient float rotationLogAY;
    public static transient float rotationLogAZ;

    // Load Config
    public static void load() {
        try {
            var path = FabricLoader.getInstance().getConfigDir().resolve("viewmodel.json");
            if (Files.exists(path)) {
                GSON.fromJson(Files.readString(path), VMCScreen.class);
            }
        } catch (Throwable t) {
            ViewModel.LOGGER.warn("Failed to load mod config", t);
        }
        calculateScaleLog();
        calculatePositionLogIX();
        calculatePositionLogIY();
        calculatePositionLogIZ();
        calculateRotationLogIX();
        calculateRotationLogIY();
        calculateRotationLogIZ();
        calculatePositionLogAX();
        calculateRotationOffLogIX();
        calculateRotationOffLogIY();
        calculateRotationOffLogIZ();
        calculatePositionLogAY();
        calculatePositionLogAZ();
        calculateRotationLogAX();
        calculateRotationLogAY();
        calculateRotationLogAZ();
    }

    // Save Config
    public static void save() {
        try {
            var path = FabricLoader.getInstance().getConfigDir().resolve("viewmodel.json");
            Files.createDirectories(path.getParent());
            Files.writeString(path, GSON.toJson(new VMCScreen()));
        } catch (Throwable t) {
            ViewModel.LOGGER.warn("Failed to save mod config", t);
        }
    }
    public static void calculateScaleLog() {
        scaleLog = 0.1f + scale * (3f - 0.1f);
    }

    public static void calculatePositionLogIX() {
        positionLogIX = -3 + positionMainX * (3 - (-3));
    }

    public static void calculatePositionLogIY() {
        positionLogIY = -3 + positionMainY * (3 - (-3));
    }

    public static void calculatePositionLogIZ() {
        positionLogIZ = -3 + positionMainZ * (3 - (-3));
    }

    public static void calculateRotationLogIX() {
        rotationLogIX = -180 + rotationMainX * (180 - (-180));
    }

    public static void calculateRotationLogIY() {
        rotationLogIY = -180 + rotationMainY * (180 - (-180));
    }

    public static void calculateRotationLogIZ() {
        rotationLogIZ = -180 + rotationMainZ * (180 - (-180));
    }

    public static void calculateRotationOffLogIX() {
        rotationLogOffIX = -180 + rotationOffX * (180 - (-180));
    }

    public static void calculateRotationOffLogIY() {
        rotationLogOffIY = -180 + rotationOffY * (180 - (-180));
    }

    public static void calculateRotationOffLogIZ() {
        rotationLogOffIZ = -180 + rotationOffZ * (180 - (-180));
    }

    public static void calculatePositionLogAX() {
        positionLogAX = -3 + positionArmX * (3 - (-3));
    }
    public static void calculatePositionLogAY() {
        positionLogAY = -3 + positionArmY * (3 - (-3));
    }

    public static void calculatePositionLogAZ() {
        positionLogAZ = -3 + positionArmZ * (3 - (-3));
    }

    public static void calculateRotationLogAX() {
        rotationLogAX = -180 + rotationArmX * (180 - (-180));
    }

    public static void calculateRotationLogAY() {
        rotationLogAY = -180 + rotationArmY * (180 - (-180));
    }

    public static void calculateRotationLogAZ() {
        rotationLogAZ = -180 + rotationArmZ * (180 - (-180));
    }
}