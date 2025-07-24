package ru.harimasa.viewmodel.config;

public class AnimateUtils {
    public static float prevMainX, prevMainY, prevMainZ, prevOffX, prevOffY, prevOffZ;

    private static float rotate(float value, float speed) {
        return value - speed <= 180 && value - speed > -180 ? value - speed : 180;
    }

    public static void animate() {
        prevMainX = VMScreen.CONFIG.instance().rotMainX;
        prevMainY = VMScreen.CONFIG.instance().rotMainY;
        prevMainZ = VMScreen.CONFIG.instance().rotMainZ;
        prevOffX = VMScreen.CONFIG.instance().rotOffX;
        prevOffY = VMScreen.CONFIG.instance().rotOffY;
        prevOffZ = VMScreen.CONFIG.instance().rotOffZ;

        if (VMScreen.CONFIG.instance().rotAnimEnable && VMScreen.CONFIG.instance().rotAnimMainX)
            VMScreen.CONFIG.instance().rotMainX = rotate(VMScreen.CONFIG.instance().rotMainX, VMScreen.CONFIG.instance().rotAnimSpeed);
        if (VMScreen.CONFIG.instance().rotAnimEnable && VMScreen.CONFIG.instance().rotAnimMainY)
            VMScreen.CONFIG.instance().rotMainY = rotate(VMScreen.CONFIG.instance().rotMainY, VMScreen.CONFIG.instance().rotAnimSpeed);
        if (VMScreen.CONFIG.instance().rotAnimEnable && VMScreen.CONFIG.instance().rotAnimMainZ)
            VMScreen.CONFIG.instance().rotMainZ = rotate(VMScreen.CONFIG.instance().rotMainZ, VMScreen.CONFIG.instance().rotAnimSpeed);
        if (VMScreen.CONFIG.instance().rotAnimEnable && VMScreen.CONFIG.instance().rotAnimOffX)
            VMScreen.CONFIG.instance().rotOffX = rotate(VMScreen.CONFIG.instance().rotOffX, VMScreen.CONFIG.instance().rotAnimSpeed);
        if (VMScreen.CONFIG.instance().rotAnimEnable && VMScreen.CONFIG.instance().rotAnimOffY)
            VMScreen.CONFIG.instance().rotOffY = rotate(VMScreen.CONFIG.instance().rotOffY, VMScreen.CONFIG.instance().rotAnimSpeed);
        if (VMScreen.CONFIG.instance().rotAnimEnable && VMScreen.CONFIG.instance().rotAnimOffZ)
            VMScreen.CONFIG.instance().rotOffZ = rotate(VMScreen.CONFIG.instance().rotOffZ, VMScreen.CONFIG.instance().rotAnimSpeed);
        VMScreen.CONFIG.save();
    }

    public static double interpolate(double oldValue, double newValue, double interpolationValue) {
        return (oldValue + (newValue - oldValue) * interpolationValue);
    }

    public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
        return (float) interpolate(oldValue, newValue, (float) interpolationValue);
    }
}
