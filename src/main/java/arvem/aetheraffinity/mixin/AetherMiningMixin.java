package arvem.aetheraffinity.mixin;

import arvem.aetheraffinity.AetherAffinity;
import com.aetherteam.aether.event.hooks.AbilityHooks;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbilityHooks.ToolHooks.class)
public class AetherMiningMixin {
    @Inject(
            method = "reduceToolEffectiveness(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/BlockState;Lnet/minecraft/item/ItemStack;F)F", at = @At("HEAD"), cancellable = true)
    private static void aetherAffinityMining(PlayerEntity player, BlockState state, ItemStack stack, float speed, CallbackInfoReturnable<Float> cir) {
        if (EnchantmentHelper.getLevel(AetherAffinity.AETHER_AFFINITY, stack) > 0){
            cir.setReturnValue(speed);
            cir.cancel();
        }
    }
}