package nightkosh.forged_in_blocks.mixin;

import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.forged_in_blocks.FiBConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static nightkosh.forged_in_blocks.ForgedInBlocks.LOGGER;

/**
 * Forged in Blocks
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mixin(AnvilBlock.class)
public class UnbreakableAnvilMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private static void forged_in_blocks$damage(BlockState state, CallbackInfoReturnable<BlockState> ci) {
        if (FiBConfigs.UNBREAKABLE_ANVIL.get()) {
            if (FiBConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Anvil damage method triggered. Going to prevent damage");
            }
            ci.setReturnValue(state);
        }
    }

}
