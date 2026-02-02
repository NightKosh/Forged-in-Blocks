package nightkosh.forged_in_blocks;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.AnvilUpdateEvent;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.forged_in_blocks.ForgedInBlocks.LOGGER;

/**
 * Forged in Blocks
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class WLEventsConfigs {

    @SubscribeEvent
    public static void onAddPackFindersEvent(AddPackFindersEvent event) {
        if (FiBConfigs.DEBUG_MODE.get()) {
            LOGGER.info("AddPackFindersEvent triggered");
        }
        if (FiBConfigs.OVERRIDE_RECIPES.get()) {
            event.addPackFinders(
                    fromNamespaceAndPath(
                            ModInfo.ID,
                            "data/forged_in_blocks/datapacks/overrides"
                    ),
                    PackType.SERVER_DATA,
                    Component.literal("Forged in Blocks: Recipe Overrides"),
                    PackSource.BUILT_IN,
                    true,
                    Pack.Position.TOP
            );
        }
    }

    @SubscribeEvent
    public static void onAnvilUpdateEvent(AnvilUpdateEvent event) {
        if (FiBConfigs.DEBUG_MODE.get()) {
            LOGGER.info("AnvilUpdateEvent triggered");
        }
        if (!event.getLeft().isEmpty() && !event.getRight().isEmpty() &&
                !event.getLeft().is(Items.ENCHANTED_BOOK) && !event.getRight().is(Items.ENCHANTED_BOOK) &&
                !event.getLeft().getItem().equals(event.getRight().getItem())) {
            if (FiBConfigs.ANVIL_CONSTANT_PRICE.get()) {
                if (FiBConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("Going to change repair experience cost");
                }
                event.setXpCost(FiBConfigs.ANVIL_REPAIR_PRICE.get());
            }
        }
    }

}
