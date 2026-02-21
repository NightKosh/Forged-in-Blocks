package nightkosh.forged_in_blocks.mixin;

import net.minecraft.world.inventory.AnvilMenu;
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
@Mixin(AnvilMenu.class)
public class NoExpLimitAnvilMenu {

    @ModifyConstant(method = "createResultInternal", constant = @Constant(intValue = 40))
    private int forged_in_blocks$createResultInternal(int originalConstant) {
        if (FiBConfigs.ANVIL_NO_EXP_LIMIT.get()) {
            if (FiBConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Anvil Menu createResultInternal method triggered. Going to remove experience limit");
            }
            return Integer.MAX_VALUE;
        } else {
            return originalConstant;
        }
    }

}
