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
import ru.matt.api.VMCScreen;

@Mixin(HeldItemRenderer.class)
public abstract class MixinHeldItemRenderer {

	@Inject(method = "renderFirstPersonItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"), cancellable = true)
	private void onRenderItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
		if (VMCScreen.enabled) {
			if (hand == Hand.MAIN_HAND) {
				matrices.translate(VMCScreen.positionLogIX, VMCScreen.positionLogIY, VMCScreen.positionLogIZ);
				matrices.scale(VMCScreen.scaleLog, VMCScreen.scaleLog, VMCScreen.scaleLog);
				matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(VMCScreen.rotationLogIX));
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(VMCScreen.rotationLogIY));
				matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(VMCScreen.rotationLogIZ));
			} else {
				matrices.translate(-VMCScreen.positionLogIX, VMCScreen.positionLogIY, VMCScreen.positionLogIZ);
				matrices.scale(VMCScreen.scaleLog, VMCScreen.scaleLog, VMCScreen.scaleLog);
				matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(VMCScreen.rotationLogOffIX));
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(VMCScreen.rotationLogOffIY));
				matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(VMCScreen.rotationLogOffIZ));
			}
			if (VMCScreen.enabledSpecial) {
				if (VMCScreen.enabledNoHands) {
					if (hand == Hand.MAIN_HAND) {
						matrices.scale(0,0,0);
					} else {
						matrices.scale(0, 0, 0);
					}
				}
			}
		}
	}

	@Inject(method = "renderFirstPersonItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderArmHoldingItem(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IFFLnet/minecraft/util/Arm;)V"), cancellable = true)
	private void onRenderArm(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
		if (VMCScreen.enabledArm) {
			matrices.translate(VMCScreen.positionLogAX, VMCScreen.positionLogAY, VMCScreen.positionLogAZ);
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(VMCScreen.rotationLogAX));
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(VMCScreen.rotationLogAY));
			matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(VMCScreen.rotationLogAZ));
		}
		if (VMCScreen.enabledSpecial) {
			if (VMCScreen.enabledNoHands) {
				if (hand == Hand.MAIN_HAND) {
					matrices.scale(0,0,0);
				} else {
					matrices.scale(0, 0, 0);
				}
			}
		}
	}
}