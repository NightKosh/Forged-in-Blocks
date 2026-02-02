package nightkosh.forged_in_blocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Forged in Blocks
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(ModInfo.ID)
public class ForgedInBlocks {

    public static ForgedInBlocks INSTANCE;

    public static final Logger LOGGER = LogManager.getLogger(ModInfo.ID);

    public ForgedInBlocks(IEventBus eventBus, ModContainer container) {
        INSTANCE = this;

        container.registerConfig(ModConfig.Type.COMMON, FiBConfigs.SPEC, ModInfo.ID + ".toml");
    }

}
