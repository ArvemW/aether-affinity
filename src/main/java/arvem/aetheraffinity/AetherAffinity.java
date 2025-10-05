package arvem.aetheraffinity;

import com.aetherteam.aether.AetherTags;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AetherAffinity implements ModInitializer {
	public static final String MOD_ID = "aether-affinity";
    public static Enchantment AETHER_AFFINITY = new AetherAffinityEnchantment();

	@Override
	public void onInitialize() {
        Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "aether_affinity"), AETHER_AFFINITY);
	}
}