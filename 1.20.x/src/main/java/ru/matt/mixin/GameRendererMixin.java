package ru.matt.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.matt.api.ClothConfigConfig;

@Mixin(value = GameRenderer.class)
public abstract class GameRendererMixin {
    @Shadow @Final private MinecraftClient client;

    @Shadow
    private void renderHand(MatrixStack matrices, Camera camera, float tickDelta) {
    }

    @Inject(method = "renderWorld", at = @At("HEAD"))
    private void onRenderHand1(float tickDelta, long limitTime, MatrixStack matrices, CallbackInfo ci) {
        if (ClothConfigConfig.enabledSpecial()) {
            if (ClothConfigConfig.hand1f()) {
                client.options.hudHidden = false;
            }
        }
    }

    @Inject(method = "renderWorld", at = @At("TAIL"))
    private void onRenderHand2(CallbackInfo ci) {
        if (ClothConfigConfig.enabledSpecial()) {
            if (ClothConfigConfig.hand1f()) {
                client.options.hudHidden = true;
            } else {
                client.options.hudHidden = false;
            }
        }
    }
}
