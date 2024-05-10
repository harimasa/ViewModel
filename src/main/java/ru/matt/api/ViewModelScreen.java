package ru.matt.api;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import ru.matt.listener.LCheckBox;

import java.text.DecimalFormat;

public class ViewModelScreen extends Screen {
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

    // Off Hand Rotations
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

    public ViewModelScreen(Screen prevision) {
        super(Text.translatable("viewmodel.config.title"));
        this.prevision = prevision;
    }

    @Override
    public void init() {
        if (enabled != null) removed();
        // Affect Items?
        enabled = addDrawableChild(new LCheckBox(width / 2 - textRenderer.getWidth(Text.translatable("viewmodel.config.option.enabled")) / 2 - 256,
                20, 24 + textRenderer.getWidth(Text.translatable("viewmodel.config.option.enabled")), 20,
                Text.translatable("viewmodel.config.option.enabled"), ViewModelConfig.enabled, cb -> ViewModelConfig.enabled = cb.isChecked()));
        // Main Settings Scale
            // Scale
        scale = addDrawableChild(new SliderWidget(width / 2 - 320, 48, 150, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ScalePos.scale"),
                        Text.translatable(FORMAT.format(ViewModelConfig.scaleLog))), ViewModelConfig.scale) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ScalePos.scale"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.scale = (float) value;
                ViewModelConfig.calculateScaleLog();
            }
        });
        // Main Settings Positions
            // Position to X
        positionMainX = addDrawableChild(new SliderWidget(width / 2 - 332, 88, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ScalePos.positionMainX"),
                        Text.translatable(FORMAT.format(ViewModelConfig.positionLogIX))), ViewModelConfig.positionMainX) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ScalePos.positionMainX"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.positionMainX = (float) value;
                ViewModelConfig.calculatePositionLogIX();
            }
        });
        // Main Settings Positions
            // Position to Y
        positionMainY = addDrawableChild(new SliderWidget(width / 2 - 332, 128, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ScalePos.positionMainY"),
                        Text.translatable(FORMAT.format(ViewModelConfig.positionLogIY))), ViewModelConfig.positionMainY) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ScalePos.positionMainY"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.positionMainY = (float) value;
                ViewModelConfig.calculatePositionLogIY();
            }
        });
        // Main Settings Positions
            // Position to Z
        positionMainZ = addDrawableChild(new SliderWidget(width / 2 - 332, 168, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ScalePos.positionMainZ"),
                        Text.translatable(FORMAT.format(ViewModelConfig.positionLogIZ))), ViewModelConfig.positionMainZ) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ScalePos.positionMainZ"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.positionMainZ = (float) value;
                ViewModelConfig.calculatePositionLogIZ();
            }
        });
        // Main Hand Rotations
            // Rotation Main Hand to X
        rotationMainX = addDrawableChild(new SliderWidget(width / 2 - 222, 88, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.MainRotation.rotationMainX"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationMainX))), ViewModelConfig.rotationMainX) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.MainRotation.rotationMainX"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationMainX = (float) value;
                ViewModelConfig.calculateRotationLogIX();
            }
        });
        // Main Hand Rotations
            // Rotation Main Hand to Y
        rotationMainY = addDrawableChild(new SliderWidget(width / 2 - 222, 128, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.MainRotation.rotationMainY"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationMainY))), ViewModelConfig.rotationMainY) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.MainRotation.rotationMainY"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationMainY = (float) value;
                ViewModelConfig.calculateRotationLogIY();
            }
        });
        // Main Hand Rotations
            // Rotation Main Hand to Z
        rotationMainZ = addDrawableChild(new SliderWidget(width / 2 - 222, 168, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.MainRotation.rotationMainZ"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationMainZ))), ViewModelConfig.rotationMainZ) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.MainRotation.rotationMainZ"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationMainZ = (float) value;
                ViewModelConfig.calculateRotationLogIZ();
            }
        });
        // Off Hand Rotations
            // Rotation Off Hand to X
        rotationOffX = addDrawableChild(new SliderWidget(width / 2 - 112, 88, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.OffRotation.rotationOffX"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationOffX))), ViewModelConfig.rotationOffX) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.OffRotation.rotationOffX"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationOffX = (float) value;
                ViewModelConfig.calculateRotationOffLogIX();
            }
        });
        // Off Hand Rotations
            // Rotation Off Hand to Y
        rotationOffY = addDrawableChild(new SliderWidget(width / 2 - 112, 128, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.OffRotation.rotationOffY"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationOffY))), ViewModelConfig.rotationOffY) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.OffRotation.rotationOffY"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationOffY = (float) value;
                ViewModelConfig.calculateRotationOffLogIY();
            }
        });
        // Off Hand Rotations
            // Rotation Off Hand to Z
        rotationOffZ = addDrawableChild(new SliderWidget(width / 2 - 112, 168, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.OffRotation.rotationOffZ"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationOffZ))), ViewModelConfig.rotationOffZ) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.OffRotation.rotationOffZ"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationOffZ = (float) value;
                ViewModelConfig.calculateRotationOffLogIZ();
            }
        });
        if (enabledArm != null) removed();
        // Arm Settings
            // Affect Arm?
        enabledArm = addDrawableChild(new LCheckBox(width / 2 - textRenderer.getWidth(Text.translatable("viewmodel.config.option.enabledArm")) / 2 + 256,
                20, 24 + textRenderer.getWidth(Text.translatable("viewmodel.config.option.enabledArm")), 20,
                Text.translatable("viewmodel.config.option.enabledArm"), ViewModelConfig.enabledArm, cb -> ViewModelConfig.enabledArm = cb.isChecked()));
        // Arm Settings
            // Rotation Arm to X
        rotationArmX = addDrawableChild(new SliderWidget(width / 2 + 112, 88, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ArmRotation.rotationArmX"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationArmX))), ViewModelConfig.rotationArmX) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ArmRotation.rotationArmX"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationArmX = (float) value;
                ViewModelConfig.calculateRotationLogAX();
            }
        });
        // Arm Settings
            // Rotation Arm to Y
        rotationArmY = addDrawableChild(new SliderWidget(width / 2 + 112, 128, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ArmRotation.rotationArmY"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationArmY))), ViewModelConfig.rotationArmY) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ArmRotation.rotationArmY"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationArmY = (float) value;
                ViewModelConfig.calculateRotationLogAY();
            }
        });
        // Arm Settings
            // Rotation Arm to Z
        rotationArmZ = addDrawableChild(new SliderWidget(width / 2 + 112, 168, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ArmRotation.rotationArmZ"),
                        Text.translatable(FORMAT.format(ViewModelConfig.rotationArmZ))), ViewModelConfig.rotationArmZ) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ArmRotation.rotationArmZ"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.rotationArmZ = (float) value;
                ViewModelConfig.calculateRotationLogAZ();
            }
        });
        // Arm Settings
            // Position Arm to X
        positionArmX = addDrawableChild(new SliderWidget(width / 2 + 222, 88, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ArmPosition.positionArmX"),
                        Text.translatable(FORMAT.format(ViewModelConfig.positionArmX))), ViewModelConfig.positionArmX) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ArmPosition.positionArmX"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.positionArmX = (float) value;
                ViewModelConfig.calculatePositionLogAX();
            }
        });
        // Arm Settings
            // Position Arm to Y
        positionArmY = addDrawableChild(new SliderWidget(width / 2 + 222, 128, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ArmPosition.positionArmY"),
                        Text.translatable(FORMAT.format(ViewModelConfig.positionArmY))), ViewModelConfig.positionArmY) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ArmPosition.positionArmY"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.positionArmY = (float) value;
                ViewModelConfig.calculatePositionLogAY();
            }
        });

        // Arm Settings
            // Position Arm to Z
        positionArmZ = addDrawableChild(new SliderWidget(width / 2 + 222, 168, 100, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("viewmodel.config.slider.category.ArmPosition.positionArmZ"),
                        Text.translatable(FORMAT.format(ViewModelConfig.positionArmZ))), ViewModelConfig.positionArmZ) {

            @Override
            public void updateMessage() {
                setMessage(Text.translatable("viewmodel.config.slider.category.ArmPosition.positionArmZ"));
            }

            @Override
            public void applyValue() {
                ViewModelConfig.positionArmZ = (float) value;
                ViewModelConfig.calculatePositionLogAZ();
            }
        });
    }

    @Override
    public void removed() {
        ViewModelConfig.save();
    }
}