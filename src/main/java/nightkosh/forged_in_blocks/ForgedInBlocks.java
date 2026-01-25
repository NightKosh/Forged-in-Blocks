package nightkosh.forged_in_blocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

/**
 * Forged in Blocks
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(ModInfo.ID)
public class ForgedInBlocks {

    public static ForgedInBlocks INSTANCE;

    public ForgedInBlocks(IEventBus eventBus, ModContainer container) {
        INSTANCE = this;
    }

}
