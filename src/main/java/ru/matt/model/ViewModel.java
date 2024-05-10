package ru.matt.model;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RotationAxis;
import ru.matt.api.ViewModelConfig;
import ru.matt.event.EventArmRenderer;
import ru.matt.event.EventHeldItemRenderer;

public class ViewModel {

    @EventHandler
    private void onHeldItemRender(EventHeldItemRenderer event) {
        if (ViewModelConfig.enabled) {
            if (event.getHand() == Hand.MAIN_HAND) {
                event.getStack().translate(ViewModelConfig.positionMainZ, ViewModelConfig.positionMainY, ViewModelConfig.positionMainZ);
                event.getStack().scale(ViewModelConfig.scale, ViewModelConfig.scale, ViewModelConfig.scale);
                event.getStack().multiply(RotationAxis.POSITIVE_X.rotationDegrees(ViewModelConfig.rotationMainX));
                event.getStack().multiply(RotationAxis.POSITIVE_Y.rotationDegrees(ViewModelConfig.rotationMainY));
                event.getStack().multiply(RotationAxis.POSITIVE_Z.rotationDegrees(ViewModelConfig.rotationMainZ));
            } else {
                event.getStack().translate(-ViewModelConfig.positionMainZ, ViewModelConfig.positionMainY, ViewModelConfig.positionMainZ);
                event.getStack().scale(ViewModelConfig.scale, ViewModelConfig.scale, ViewModelConfig.scale);
                event.getStack().multiply(RotationAxis.POSITIVE_X.rotationDegrees(ViewModelConfig.rotationOffX));
                event.getStack().multiply(RotationAxis.POSITIVE_Y.rotationDegrees(ViewModelConfig.rotationOffY));
                event.getStack().multiply(RotationAxis.POSITIVE_Z.rotationDegrees(ViewModelConfig.rotationOffZ));
            }
        }
    }

    @EventHandler
    private void onRenderArm(EventArmRenderer arm) {
        if (ViewModelConfig.enabledArm) {
            arm.getStack().translate(ViewModelConfig.positionArmX, ViewModelConfig.positionArmY, ViewModelConfig.positionArmZ);
            arm.getStack().multiply(RotationAxis.POSITIVE_X.rotationDegrees(ViewModelConfig.rotationArmX));
            arm.getStack().multiply(RotationAxis.POSITIVE_Y.rotationDegrees(ViewModelConfig.rotationArmY));
            arm.getStack().multiply(RotationAxis.POSITIVE_Z.rotationDegrees(ViewModelConfig.rotationArmZ));
        }
    }
}