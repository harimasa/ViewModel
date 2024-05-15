package ru.matt.api;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import ru.matt.listener.LCheckWidget;

import java.text.DecimalFormat;

public class VMScreen extends Screen {
    public static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    public final Screen prevision;

    // enabled???
    public CheckboxWidget enabled;

    // Main Settings Scale and Positions
    public SliderWidget scale;
    public SliderWidget positionMainX;
    public SliderWidget positionMainY;
    public SliderWidget positionMainZ;

    // Main Hand Rotations
    public SliderWidget rotationMainX;
    public SliderWidget rotationMainY;
    public SliderWidget rotationMainZ;

    // Offhand Rotations
    public SliderWidget rotationOffX;
    public SliderWidget rotationOffY;
    public SliderWidget rotationOffZ;

    // Arm Settings

    // Enabled Arm settings?
    public CheckboxWidget enabledArm;

    // Rotations Arm
    public SliderWidget rotationArmX;
    public SliderWidget rotationArmY;
    public SliderWidget rotationArmZ;

    // Positions Arm
    public SliderWidget positionArmX;
    public SliderWidget positionArmY;
    public SliderWidget positionArmZ;

    // Big Special Settings

    // Enabled Big Special settings?
    public CheckboxWidget enabledSpecial;

    // Enabled NoHands?
    public CheckboxWidget enabledNoHands;

    // Enabled Hands In F1?
    public CheckboxWidget enabledHandsF1;

    public VMScreen(Screen prevision) {
        super(Text.translatable("viewmodel.config.title"));
        this.prevision = prevision;
    }

    @Override
    public void init() {
        if (enabled != null) removed();

        // Affect Items?
        enabled = addDrawableChild(new LCheckWidget(width / 2 - textRenderer.getWidth(Text.translatable("viewmodel.enabled")) / 2 - 210,
                10, 24 + textRenderer.getWidth(Text.translatable("viewmodel.enabled")), 20,
                Text.translatable("viewmodel.enabled"), VMCScreen.enabled, cb -> VMCScreen.enabled = cb.isChecked()));

        // Scale
        scale = addDrawableChild(new SliderWidget(width / 2 - 273, 38, 150, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.scale"),
                        Text.translatable(FORMAT.format(VMCScreen.scaleLog))), VMCScreen.scale) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.scale"),
                        Text.literal(FORMAT.format(0.1f + value * (3f - 0.1f)))));
            }

            @Override
            public void applyValue() {
                VMCScreen.scale = (float) value;
                VMCScreen.calculateScaleLog();
            }
        });

        // Position Main Hand to X
        positionMainX = addDrawableChild(new SliderWidget(width / 2 - 336, 78, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionMainX"),
                        Text.translatable(FORMAT.format(VMCScreen.positionLogIX))), VMCScreen.positionMainX) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionMainX"),
                        Text.literal(FORMAT.format(-3f + value * (3f - (-3f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.positionMainX = (float) value;
                VMCScreen.calculatePositionLogIX();
            }
        });

        // Position Main Hand to Y
        positionMainY = addDrawableChild(new SliderWidget(width / 2 - 336, 118, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionMainY"),
                        Text.translatable(FORMAT.format(VMCScreen.positionLogIY))), VMCScreen.positionMainY) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionMainY"),
                        Text.literal(FORMAT.format(-3f + value * (3f - (-3f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.positionMainY = (float) value;
                VMCScreen.calculatePositionLogIY();
            }
        });

        // Position Main Hand to Z
        positionMainZ = addDrawableChild(new SliderWidget(width / 2 - 336, 158, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionMainZ"),
                        Text.translatable(FORMAT.format(VMCScreen.positionLogIZ))), VMCScreen.positionMainZ) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionMainZ"),
                        Text.literal(FORMAT.format(-3f + value * (3f - (-3f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.positionMainZ = (float) value;
                VMCScreen.calculatePositionLogIZ();
            }
        });

        // Rotation Main Hand to X
        rotationMainX = addDrawableChild(new SliderWidget(width / 2 - 242, 78, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationMainX"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogIX))), VMCScreen.rotationMainX) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationMainX"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationMainX = (float) value;
                VMCScreen.calculateRotationLogIX();
            }
        });

        // Rotation Main Hand to Y
        rotationMainY = addDrawableChild(new SliderWidget(width / 2 - 242, 118, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationMainY"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogIY))), VMCScreen.rotationMainY) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationMainY"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationMainY = (float) value;
                VMCScreen.calculateRotationLogIY();
            }
        });

        // Rotation Main Hand to Z
        rotationMainZ = addDrawableChild(new SliderWidget(width / 2 - 242, 158, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationMainZ"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogIY))), VMCScreen.rotationMainY) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationMainZ"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationMainZ = (float) value;
                VMCScreen.calculateRotationLogIZ();
            }
        });

        // Rotation Offhand to X
        rotationOffX = addDrawableChild(new SliderWidget(width / 2 - 148, 78, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationOffX"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogOffIX))), VMCScreen.rotationOffX) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationOffX"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationOffX = (float) value;
                VMCScreen.calculateRotationOffLogIX();
            }
        });

        // Rotation Offhand to Y
        rotationOffY = addDrawableChild(new SliderWidget(width / 2 - 148, 118, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationOffY"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogOffIY))), VMCScreen.rotationOffY) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationOffY"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationOffY = (float) value;
                VMCScreen.calculateRotationOffLogIY();
            }
        });

        // Rotation Offhand to Z
        rotationOffZ = addDrawableChild(new SliderWidget(width / 2 - 148, 158, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationOffZ"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogOffIZ))), VMCScreen.rotationOffZ) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationOffZ"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationOffZ = (float) value;
                VMCScreen.calculateRotationOffLogIZ();
            }
        });
        if (enabledArm != null) removed();

        // Affect Arm?
        enabledArm = addDrawableChild(new LCheckWidget(width / 2 - textRenderer.getWidth(Text.translatable("viewmodel.enabledArm")) / 2 + 240,
                10, 24 + textRenderer.getWidth(Text.translatable("viewmodel.enabledArm")), 20,
                Text.translatable("viewmodel.enabledArm"), VMCScreen.enabledArm, cb -> VMCScreen.enabledArm = cb.isChecked()));

        // Rotation Arm to X
        rotationArmX = addDrawableChild(new SliderWidget(width / 2 + 148, 38, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationArmX"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogAX))), VMCScreen.rotationArmX) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationArmX"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationArmX = (float) value;
                VMCScreen.calculateRotationLogAX();
            }
        });

        // Rotation Arm to Y
        rotationArmY = addDrawableChild(new SliderWidget(width / 2 + 148, 78, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationArmY"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogAY))), VMCScreen.rotationArmY) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationArmY"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationArmY = (float) value;
                VMCScreen.calculateRotationLogAY();
            }
        });

        // Rotation Arm to Z
        rotationArmZ = addDrawableChild(new SliderWidget(width / 2 + 148, 118, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationArmZ"),
                        Text.translatable(FORMAT.format(VMCScreen.rotationLogAZ))), VMCScreen.rotationArmZ) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.rotationArmZ"),
                        Text.literal(FORMAT.format(-180f + value * (180f - (-180f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.rotationArmZ = (float) value;
                VMCScreen.calculateRotationLogAZ();
            }
        });

        // Position Arm to X
        positionArmX = addDrawableChild(new SliderWidget(width / 2 + 242, 38, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionArmX"),
                        Text.translatable(FORMAT.format(VMCScreen.positionLogAX))), VMCScreen.positionArmX) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionArmX"),
                        Text.literal(FORMAT.format(-3f + value * (3f - (-3f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.positionArmX = (float) value;
                VMCScreen.calculatePositionLogAX();
            }
        });

        // Position Arm to Y
        positionArmY = addDrawableChild(new SliderWidget(width / 2 + 242, 78, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionArmY"),
                        Text.translatable(FORMAT.format(VMCScreen.positionLogAY))), VMCScreen.positionArmY) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionArmY"),
                        Text.literal(FORMAT.format(-3f + value * (3f - (-3f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.positionArmY = (float) value;
                VMCScreen.calculatePositionLogAY();
            }
        });

        // Position Arm to Z
        positionArmZ = addDrawableChild(new SliderWidget(width / 2 + 242, 118, 90, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionArmZ"),
                        Text.translatable(FORMAT.format(VMCScreen.positionLogAZ))), VMCScreen.positionArmZ) {

            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.slider.positionArmZ"),
                        Text.literal(FORMAT.format(-3f + value * (3f - (-3f))))));
            }

            @Override
            public void applyValue() {
                VMCScreen.positionArmZ = (float) value;
                VMCScreen.calculatePositionLogAZ();
            }
        });
        if (enabledSpecial != null) removed();

        // Enabled BigSpecial Settings?
        enabledSpecial = addDrawableChild(new LCheckWidget(width / 2 - textRenderer.getWidth(Text.translatable("viewmodel.enabledSpecial")) / 2 + 50,
                38, 24 + textRenderer.getWidth(Text.translatable("viewmodel.enabledSpecial")), 20,
                Text.translatable("viewmodel.enabledSpecial"), VMCScreen.enabledSpecial, cb -> VMCScreen.enabledSpecial = cb.isChecked()));

        // Enabled No Hands?
        enabledNoHands = addDrawableChild(new LCheckWidget(width / 2 - textRenderer.getWidth(Text.translatable("viewmodel.enabledNoHands")) / 2 + 24,
                78, 24 + textRenderer.getWidth(Text.translatable("viewmodel.enabledNoHands")), 20,
                Text.translatable("viewmodel.enabledNoHands"), VMCScreen.enabledNoHands, cb -> VMCScreen.enabledNoHands = cb.isChecked()));

        // Enabled Hands In F1?
        enabledHandsF1 = addDrawableChild(new LCheckWidget(width / 2 - textRenderer.getWidth(Text.translatable("viewmodel.enabledHandsF1")) / 2 + 18,
                118, 24 + textRenderer.getWidth(Text.translatable("viewmodel.enabledHandsF1")), 20,
                Text.translatable("viewmodel.enabledHandsF1"), VMCScreen.enabledHandsF1, cb -> VMCScreen.enabledHandsF1 = cb.isChecked()));
    }

    // Save config
    @Override
    public void removed() {
        VMCScreen.save();
    }
}