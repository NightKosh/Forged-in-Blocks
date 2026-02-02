package nightkosh.forged_in_blocks;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Forged in Blocks
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FiBConfigs {

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // mob cap
    public static ModConfigSpec.ConfigValue<Boolean> OVERRIDE_RECIPES;

    // anvil
    public static ModConfigSpec.ConfigValue<Boolean> ANVIL_CONSTANT_PRICE;
    public static ModConfigSpec.ConfigValue<Integer> ANVIL_REPAIR_PRICE;

    // other
    public static ModConfigSpec.ConfigValue<Boolean> DEBUG_MODE;

    static {
        BUILDER.push("Configs for Withered Lands Mod");

        // recipes
        OVERRIDE_RECIPES = BUILDER.define("Override armors/weapons/tools crafting recipes", true);

        // anvil
        ANVIL_CONSTANT_PRICE = BUILDER.define("Anvil repair price is constant", true);
        ANVIL_REPAIR_PRICE = BUILDER.define("Anvil repair price", 1);

        // other
        DEBUG_MODE = BUILDER.comment("Enable additional dev logs")
                .define("Debug Mode", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
