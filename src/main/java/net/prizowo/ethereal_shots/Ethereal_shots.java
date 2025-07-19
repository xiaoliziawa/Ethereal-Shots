package net.prizowo.ethereal_shots;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.prizowo.ethereal_shots.enchant.EtherealShotsEnchantment;

@Mod(Ethereal_shots.MODID)
public class Ethereal_shots {
    public static final String MODID = "ethereal_shots";
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);
    public static final RegistryObject<Enchantment> ETHEREAL_SHOTS = ENCHANTMENTS.register("ethereal_shots", EtherealShotsEnchantment::new);

    public Ethereal_shots(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ENCHANTMENTS.register(modEventBus);
    }
}
