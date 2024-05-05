package ru.matt.model;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RotationAxis;
import ru.matt.event.EventHeldItemRenderer;

import static ru.matt.api.ClothConfigConfig.*;


public class ViewModel {

    @EventHandler
    private void onHeldItemRender(EventHeldItemRenderer event) {
        if (event.getHand() == Hand.MAIN_HAND) {
            event.getStack().translate(positionMainX(), positionMainY(), positionMainZ());
            event.getStack().scale(scale(), scale(), scale());
            event.getStack().multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotationMainX()));
            event.getStack().multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationMainY()));
            event.getStack().multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotationMainZ()));
        } else {
            event.getStack().translate(-positionMainX(), positionMainY(), positionMainZ());
            event.getStack().scale(scale(), scale(), scale());
            event.getStack().multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotationOffX()));
            event.getStack().multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationOffY()));
            event.getStack().multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotationOffZ()));
        }
    }
}