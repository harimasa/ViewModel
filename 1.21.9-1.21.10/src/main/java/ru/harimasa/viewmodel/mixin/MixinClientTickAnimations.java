package ru.harimasa.viewmodel.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.harimasa.viewmodel.config.VMConfig;
import ru.harimasa.viewmodel.config.VMScreen;

@Mixin(MinecraftClient.class)
public abstract class MixinClientTickAnimations {
    @Inject(method = "tick", at = @At("TAIL"))
    private void vm_disableEquipAnimation(CallbackInfo ci) {
        if (VMScreen.CONFIG.instance().animEnable && VMScreen.CONFIG.instance().enumOption == VMConfig.Templates.Default) {
            MinecraftClient mc = (MinecraftClient) (Object) this;
            if (mc.player == null || mc.getEntityRenderDispatcher() == null) {
                return;
            }

            IHeldItemRenderer itemRendererAccessor = (IHeldItemRenderer) mc.getEntityRenderDispatcher().getHeldItemRenderer();
            if (itemRendererAccessor.getEquippedProgressMainHand() < 1.0F) {
                itemRendererAccessor.setEquippedProgressMainHand(1.0F);
                itemRendererAccessor.setItemStackMainHand(mc.player.getMainHandStack());
            }

            if (itemRendererAccessor.getEquippedProgressOffHand() < 1.0F) {
                itemRendererAccessor.setEquippedProgressOffHand(1.0F);
                itemRendererAccessor.setItemStackOffHand(mc.player.getOffHandStack());
            }
        }
    }
}