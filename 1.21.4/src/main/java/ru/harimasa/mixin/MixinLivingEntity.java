package ru.harimasa.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.harimasa.viewmodel.config.VMScreen;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @Inject(method = {"getHandSwingDuration"}, at = {@At("HEAD")}, cancellable = true)
    private void getArmSwingAnimationEnd(final CallbackInfoReturnable<Integer> info) {
        if (VMScreen.CONFIG.instance().animEnable && VMScreen.CONFIG.instance().slowAnim) {
            info.setReturnValue((int) VMScreen.CONFIG.instance().slowAnimValue);
        }
    }
}