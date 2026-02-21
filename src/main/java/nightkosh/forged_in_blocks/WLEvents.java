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
public class WLEvents {

    @SubscribeEvent
    public static void onAddPackFindersEvent(AddPackFindersEvent event) {
        if (FiBConfigs.OVERRIDE_RECIPES.get()) {
            if (FiBConfigs.DEBUG_MODE.get()) {
                LOGGER.info("AddPackFindersEvent triggered. Going to override recipes");
            }
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
        var itemToRepair = event.getLeft();
        var material = event.getRight();
        if (!itemToRepair.isEmpty() && !material.isEmpty() &&
                !itemToRepair.is(Items.ENCHANTED_BOOK) && !material.is(Items.ENCHANTED_BOOK) &&
                itemToRepair.getItem().isDamaged(itemToRepair) &&
                !itemToRepair.getItem().equals(material.getItem()) &&
                itemToRepair.isValidRepairItem(material)) {
            if (FiBConfigs.ANVIL_CONSTANT_PRICE.get()) {
                if (FiBConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("AnvilUpdateEvent triggered. Going to change repair experience cost");
                }
                event.setXpCost(FiBConfigs.ANVIL_REPAIR_PRICE.get());
                event.setMaterialCost(FiBConfigs.ANVIL_REPAIR_MATERIAL_PRICE.get());
                itemToRepair.setDamageValue(0);
                event.setOutput(itemToRepair);
            }
        }
    }

}
