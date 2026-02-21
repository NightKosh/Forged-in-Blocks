package nightkosh.forged_in_blocks.mixin;

import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import nightkosh.forged_in_blocks.FiBConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import static nightkosh.forged_in_blocks.ForgedInBlocks.LOGGER;

/**
 * Forged in Blocks
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mixin(AnvilScreen.class)
public class NoExpLimitAnvilScreen {

    @ModifyConstant(method = "renderLabels", constant = @Constant(intValue = 40))
    private int forged_in_blocks$renderLabels(int originalConstant) {
        if (FiBConfigs.ANVIL_NO_EXP_LIMIT.get()) {
            if (FiBConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Anvil Screen renderLabels method triggered. Going to remove experience limit");
            }
            return Integer.MAX_VALUE;
        } else {
            return originalConstant;
        }
    }

}
