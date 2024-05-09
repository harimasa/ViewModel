package ru.matt.event;

import net.minecraft.client.util.math.MatrixStack;

public class EventArmRenderer extends Event {
    private final MatrixStack stack;

    public EventArmRenderer(MatrixStack stack) {
        this.stack = stack;
    }

    public MatrixStack getStack() {
        return stack;
    }
}