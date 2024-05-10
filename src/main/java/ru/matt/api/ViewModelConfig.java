package ru.matt.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import ru.matt.ViewModel;

import java.lang.reflect.Modifier;
import java.nio.file.Files;

public class ViewModelConfig {
    public static final transient Gson GSON = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

    // Enabled?
    public static boolean enabled = true;

    // Main Settings Scale and Positions
    public static float scale = 1f;
    public static float positionMainX = 0f;
    public static float positionMainY = 0f;
    public static float positionMainZ = 0f;

    // Main Hand Rotations
    public static float rotationMainX = 0f;
    public static float rotationMainY = 0f;
    public static float rotationMainZ = 0f;

    // Off Hand Rotations
    public static float rotationOffX = 0f;
    public static float rotationOffY = 0f;
    public static float rotationOffZ = 0f;

    // Arm Settings

    // Enabled Arm Settings?
    public static boolean enabledArm = false;
        // Rotations Arm
    public static float rotationArmX = 0f;
    public static float rotationArmY = 0f;
    public static float rotationArmZ = 0f;

        // Positions Arm
    public static float positionArmX = 0f;
    public static float positionArmY = 0f;
    public static float positionArmZ = 0f;

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
                GSON.fromJson(Files.readString(path), ViewModelConfig.class);
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
            Files.writeString(path, GSON.toJson(new ViewModelConfig()));
        } catch (Throwable t) {
            ViewModel.LOGGER.warn("Failed to save mod config", t);
        }
    }
    public static void calculateScaleLog() {
        scaleLog = scale < 0.5f ? scale * 1.8f + 0.1f : (scale - 0.5f) * 1.8f + 1f;
    }

    public static void calculatePositionLogIX() {
        positionLogIX = positionMainX < 0.5f ? positionMainX * 360f - 90f : (positionMainX - 0.5f) * 360f + 90f;;
    }

    public static void calculatePositionLogIY() {
        positionLogIY = positionMainY < 0.5f ? positionMainY * 360f - 90f : (positionMainY - 0.5f) * 360f + 90f;;
    }

    public static void calculatePositionLogIZ() {
        positionLogIZ = positionMainZ < 0.5f ? positionMainZ * 360f - 90f : (positionMainZ - 0.5f) * 360f + 90f;;
    }

    public static void calculateRotationLogIX() {
        rotationLogIX = rotationMainX < 0.5D ? rotationMainX * 1.8f + 0.1f : (rotationMainX - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationLogIY() {
        rotationLogIY = rotationMainY < 0.5D ? rotationMainY * 1.8f + 0.1f : (rotationMainY - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationLogIZ() {
        rotationLogIZ = rotationMainZ < 0.5D ? rotationMainZ * 1.8f + 0.1f : (rotationMainZ - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationOffLogIX() {
        rotationLogOffIX = rotationOffX < 0.5D ? rotationOffX * 1.8f + 0.1f : (rotationOffX - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationOffLogIY() {
        rotationLogOffIY = rotationOffY < 0.5D ? rotationOffY * 1.8f + 0.1f : (rotationOffY - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationOffLogIZ() {
        rotationLogOffIZ = rotationOffZ < 0.5D ? rotationOffZ * 1.8f + 0.1f : (rotationOffZ - 0.5f) * 18f + 1f;
    }

    public static void calculatePositionLogAX() {
        positionLogAX = positionArmX < 0.5D ? positionArmX * 1.8f + 0.1f : (positionArmX - 0.5f) * 18f + 1f;
    }
    public static void calculatePositionLogAY() {
        positionLogAY = positionArmY < 0.5D ? positionArmY * 1.8f + 0.1f : (positionArmY - 0.5f) * 18f + 1f;
    }

    public static void calculatePositionLogAZ() {
        positionLogAZ = positionArmZ < 0.5D ? positionArmZ * 1.8f + 0.1f : (positionArmZ - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationLogAX() {
        rotationLogAX = rotationArmX < 0.5D ? rotationArmX * 1.8f + 0.1f : (rotationArmX - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationLogAY() {
        rotationLogAY = rotationArmY < 0.5D ? rotationArmY * 1.8f + 0.1f : (rotationArmY - 0.5f) * 18f + 1f;
    }

    public static void calculateRotationLogAZ() {
        rotationLogAZ = rotationArmZ < 0.5D ? rotationArmZ * 1.8f + 0.1f : (rotationArmZ - 0.5f) * 18f + 1f;
    }

}