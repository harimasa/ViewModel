package ru.harimasa.viewmodel.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.harimasa.viewmodel.config.VMScreen;

@Mixin(HeldItemRenderer.class)
public abstract class MixinHeldItemRenderer {
    @Shadow
    protected abstract void applyEatOrDrinkTransformation(MatrixStack var1, float var2, Arm var3, ItemStack var4, PlayerEntity var5);

    @Shadow
    protected abstract void applyEquipOffset(MatrixStack var1, Arm var2, float var3);

    @Inject(method = "renderFirstPersonItem", at = @At("HEAD"))
    public void onRenderItem(AbstractClientPlayerEntity player, float tickProgress, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, OrderedRenderCommandQueue orderedRenderCommandQueue, int light, CallbackInfo ci) {
        matrices.push();
        if (VMScreen.CONFIG.instance().enable) {
            if (VMScreen.CONFIG.instance().affectArm || !item.isEmpty()) {
                if (hand == Hand.MAIN_HAND) {
                    matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(VMScreen.CONFIG.instance().rotMainX));
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(VMScreen.CONFIG.instance().rotMainY));
                    matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(VMScreen.CONFIG.instance().rotMainZ));
                    matrices.translate(VMScreen.CONFIG.instance().posMainX, VMScreen.CONFIG.instance().posMainY, VMScreen.CONFIG.instance().posMainZ);
                } else {
                    matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(VMScreen.CONFIG.instance().rotOffX));
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(VMScreen.CONFIG.instance().rotOffY));
                    matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(VMScreen.CONFIG.instance().rotOffZ));
                    matrices.translate(VMScreen.CONFIG.instance().posOffX, VMScreen.CONFIG.instance().posOffY, VMScreen.CONFIG.instance().posOffZ);
                }
            }
        }
    }

    @Inject(method = "renderFirstPersonItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderArmHoldingItem(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;IFFLnet/minecraft/util/Arm;)V"))
    private void onRenderArm(AbstractClientPlayerEntity player, float tickProgress, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, OrderedRenderCommandQueue orderedRenderCommandQueue, int light, CallbackInfo ci) {
        matrices.push();
        if (VMScreen.CONFIG.instance().affectArm) {
            matrices.translate(VMScreen.CONFIG.instance().posArmX, VMScreen.CONFIG.instance().posArmY, VMScreen.CONFIG.instance().posArmZ);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(VMScreen.CONFIG.instance().rotArmX));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(VMScreen.CONFIG.instance().rotArmY));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(VMScreen.CONFIG.instance().rotArmZ));
        }
    }

    @Inject(method = "renderFirstPersonItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemDisplayContext;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;I)V"))
    private void scaleItems(AbstractClientPlayerEntity player, float tickProgress, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, OrderedRenderCommandQueue orderedRenderCommandQueue, int light, CallbackInfo ci) {
        matrices.push();
        if (VMScreen.CONFIG.instance().enable && !VMScreen.CONFIG.instance().animEnable) {
            if (hand == Hand.MAIN_HAND) {
                matrices.scale(VMScreen.CONFIG.instance().mainScale, VMScreen.CONFIG.instance().mainScale, VMScreen.CONFIG.instance().mainScale);
            } else {
                matrices.scale(VMScreen.CONFIG.instance().offScale, VMScreen.CONFIG.instance().offScale, VMScreen.CONFIG.instance().offScale);
            }
        }
    }

    @Inject(method = "renderFirstPersonItem", at = @At("TAIL"))
    public void matricesPop(AbstractClientPlayerEntity player, float tickProgress, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, OrderedRenderCommandQueue orderedRenderCommandQueue, int light, CallbackInfo ci) {
        matrices.pop();
    }

    @Inject(method = "renderFirstPersonItem", at = @At("HEAD"), cancellable = true)
    private void modifyPosAndRot(AbstractClientPlayerEntity player, float tickProgress, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, OrderedRenderCommandQueue orderedRenderCommandQueue, int light, CallbackInfo ci) {
        if (VMScreen.CONFIG.instance().animEnable && !item.isEmpty()) {
            if (!item.contains(DataComponentTypes.MAP_ID)) {
                boolean isMainHand = (hand == Hand.MAIN_HAND);
                Arm arm = isMainHand ? player.getMainArm() : player.getMainArm().getOpposite();
                matrices.push();
                boolean usingItem = player.isUsingItem() && player.getActiveHand() == hand;
                boolean isVanillaAction = false;
                if (usingItem) {
                    switch (item.getUseAction()) {
                        case EAT:
                        case DRINK:
                            this.applyEatOrDrinkTransformation(matrices, tickProgress, arm, item, player);
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            isVanillaAction = true;
                            break;
                        case BOW:
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            this.applyBowTransform(matrices, player, item, tickProgress, arm);
                            isVanillaAction = true;
                            break;
                        case SPEAR:
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            this.applySpearTransform(matrices, player, item, tickProgress, arm);
                            isVanillaAction = true;
                            break;
                    }
                }
                if (!isVanillaAction) this.customSwing(player, hand, swingProgress, equipProgress, matrices);
                if (hand == Hand.MAIN_HAND) matrices.scale(VMScreen.CONFIG.instance().mainScale, VMScreen.CONFIG.instance().mainScale, VMScreen.CONFIG.instance().mainScale);
                else matrices.scale(VMScreen.CONFIG.instance().offScale, VMScreen.CONFIG.instance().offScale, VMScreen.CONFIG.instance().offScale);
                HeldItemRenderer heldItemRenderer = (HeldItemRenderer) (Object) this;
                heldItemRenderer.renderItem(player, item, arm == Arm.RIGHT ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, matrices, orderedRenderCommandQueue, light);
                matrices.pop();
                ci.cancel();
            }
        }
    }

    @Unique
    private void customSwing(AbstractClientPlayerEntity player, Hand hand, float swingProgress, float equipProgress, MatrixStack matrices) {
        boolean isMainHand = hand == Hand.MAIN_HAND;
        Arm arm = isMainHand ? player.getMainArm() : player.getMainArm().getOpposite();
        float g = MathHelper.sin(MathHelper.sqrt(swingProgress) * 3.1415927F);
        switch (VMScreen.CONFIG.instance().enumOption) {
            case Default:
                applyEquipOffset(matrices, arm, equipProgress);
                translateToViewModelOff(matrices);
                applySwingOffset(matrices, arm, swingProgress);
                translateBackOff(matrices);
                break;
            case Alternative:
                applyEquipOffset(matrices, arm, 0);
                translateToViewModel(matrices);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(50f));
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-60f));
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(110f + 20f * g));
                translateBack(matrices);
        }
    }

    @Unique
    private void applyBowTransform(MatrixStack matrices, AbstractClientPlayerEntity player, ItemStack item, float tickDelta, Arm arm) {
        int dir = arm == Arm.RIGHT ? 1 : -1;
        matrices.translate((float) dir * -0.2785682F, 0.18344387F, 0.15731531F);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-13.935F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float) dir * 35.3F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) dir * -9.785F));
        float m = (float) item.getMaxUseTime(player) - ((float) player.getItemUseTimeLeft() - tickDelta + 1.0F);
        float f = m / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        if (f > 0.1F) {
            float g = MathHelper.sin((m - 0.1F) * 1.3F);
            float h = f - 0.1F;
            float j = g * h;
            matrices.translate(j * 0.0F, j * 0.004F, j * 0.0F);
        }
        matrices.translate(f * 0.0F, f * 0.0F, f * 0.04F);
        matrices.scale(1.0F, 1.0F, 1.0F + f * 0.2F);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees((float) dir * 45.0F));
    }

    @Unique
    private void applySpearTransform(MatrixStack matrices, AbstractClientPlayerEntity player, ItemStack item, float tickDelta, Arm arm) {
        int dir = arm == Arm.RIGHT ? 1 : -1;
        matrices.translate((float) dir * -0.5F, 0.7F, 0.1F);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-55.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float) dir * 35.3F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) dir * -9.785F));
        float m = (float) item.getMaxUseTime(player) - ((float) player.getItemUseTimeLeft() - tickDelta + 1.0F);
        float f = m / 10.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        if (f > 0.1F) {
            float g = MathHelper.sin((m - 0.1F) * 1.3F);
            float h = f - 0.1F;
            float j = g * h;
            matrices.translate(j * 0.0F, j * 0.004F, j * 0.0F);
        }
        matrices.translate(0.0F, 0.0F, f * 0.2F);
        matrices.scale(1.0F, 1.0F, 1.0F + f * 0.2F);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees((float) dir * 45.0F));
    }

    @Unique
    private void applySwingOffset(@NotNull MatrixStack matrices, Arm arm, float swingProgress) {
        int i = arm == Arm.RIGHT ? 1 : -1;
        float f = MathHelper.sin(swingProgress * swingProgress * 3.1415927F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float) i * (45.0F + f * -20.0F)));
        float g = MathHelper.sin(MathHelper.sqrt(swingProgress) * 3.1415927F);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) i * g * -20.0F));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(g * -80.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float) i * -45.0F));
    }

    @Unique
    private void translateToViewModel(MatrixStack matrices) {
        if (VMScreen.CONFIG.instance().enable) matrices.translate(VMScreen.CONFIG.instance().posMainX, VMScreen.CONFIG.instance().posMainY, VMScreen.CONFIG.instance().posMainZ);
    }

    @Unique
    private void translateBack(MatrixStack matrices) {
        if (VMScreen.CONFIG.instance().enable) matrices.translate(-VMScreen.CONFIG.instance().posMainX, -VMScreen.CONFIG.instance().posMainY, -VMScreen.CONFIG.instance().posMainZ);
    }

    @Unique
    private void translateToViewModelOff(MatrixStack matrices) {
        if (VMScreen.CONFIG.instance().enable) matrices.translate(-VMScreen.CONFIG.instance().posMainX, VMScreen.CONFIG.instance().posMainY, VMScreen.CONFIG.instance().posMainZ);
    }

    @Unique
    private void translateBackOff(MatrixStack matrices) {
        if (VMScreen.CONFIG.instance().enable) matrices.translate(VMScreen.CONFIG.instance().posMainX, -VMScreen.CONFIG.instance().posMainY, -VMScreen.CONFIG.instance().posMainZ);
    }
}