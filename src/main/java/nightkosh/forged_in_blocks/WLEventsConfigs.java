package nightkosh.forged_in_blocks;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

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
        event.addPackFinders(
                fromNamespaceAndPath(
                        ModInfo.ID,
                        "data/forged_in_blocks/datapacks/overrides"
                ),
                PackType.SERVER_DATA,
                Component.literal("Forged in Blocks: Recipe Overrides"),
                PackSource.BUILT_IN,      // если в твоей версии нет BUILT_IN — ставь DEFAULT
                true,
                Pack.Position.TOP
        );
    }

}
