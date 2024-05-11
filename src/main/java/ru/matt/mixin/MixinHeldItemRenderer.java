package ru.matt.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RotationAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.matt.api.ClothConfigConfig;

import static ru.matt.api.ClothConfigConfig.*;

@Mixin(HeldItemRenderer.class)
public abstract class MixinHeldItemRenderer {

	@Inject(method = "renderFirstPersonItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"), cancellable = true)
	private void onRenderItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
		if (ClothConfigConfig.enabled()) {
			if (hand == Hand.MAIN_HAND) {
				matrices.translate(positionMainX(), positionMainY(), positionMainZ());
				matrices.scale(scale(), scale(), scale());
				matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotationMainX()));
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationMainY()));
				matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotationMainZ()));
			} else {
				matrices.translate(-positionMainX(), positionMainY(), positionMainZ());
				matrices.scale(scale(), scale(), scale());
				matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotationOffX()));
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationOffY()));
				matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotationOffZ()));
			}
		}
	}

	@Inject(method = "renderFirstPersonItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderArmHoldingItem(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IFFLnet/minecraft/util/Arm;)V"), cancellable = true)
	private void onRenderArm(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
		if (ClothConfigConfig.enabledArm()) {
			matrices.translate(positionArmX(), positionArmY(), positionArmZ());
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotationArmX()));
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationArmY()));
			matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotationArmZ()));
		}
	}
}