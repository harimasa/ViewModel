package ru.matt.event;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Hand;

public class EventHeldItemRenderer extends Event {
    private final Hand hand;
    private final MatrixStack stack;

    public EventHeldItemRenderer(Hand hand, MatrixStack stack) {
        this.hand = hand;
        this.stack = stack;
    }

    public Hand getHand() {
        return hand;
    }

    public MatrixStack getStack() {
        return stack;
    }
}