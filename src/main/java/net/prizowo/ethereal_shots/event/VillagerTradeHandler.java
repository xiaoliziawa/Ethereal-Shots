package net.prizowo.ethereal_shots.event;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.prizowo.ethereal_shots.Ethereal_shots;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = Ethereal_shots.MODID)
public class VillagerTradeHandler {
    
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FLETCHER) {
            event.getTrades().get(5).add(new EtherealShotsBookTrade());
        }
    }
    
    public static class EtherealShotsBookTrade implements VillagerTrades.ItemListing {
        
        @Override
        public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
            ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
            EnchantedBookItem.addEnchantment(enchantedBook, new EnchantmentInstance(Ethereal_shots.ETHEREAL_SHOTS.get(), 1));
            ItemStack emeralds = new ItemStack(Items.EMERALD, 32);
            ItemStack book = new ItemStack(Items.BOOK);
            return new MerchantOffer(emeralds, book, enchantedBook, 1, 30, 0.2f);
        }
    }
}