package net.prizowo.ethereal_shots.event;

import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.prizowo.ethereal_shots.entity.EtherealArrowEntity;
import net.prizowo.ethereal_shots.Ethereal_shots;

@Mod.EventBusSubscriber(modid = Ethereal_shots.MODID)
public class BowEventHandler {

    @SubscribeEvent
    public static void onArrowNock(ArrowNockEvent event) {
        ItemStack bow = event.getBow();
        Player player = event.getEntity();
        if (bow.getItem() instanceof BowItem && EnchantmentHelper.getItemEnchantmentLevel(Ethereal_shots.ETHEREAL_SHOTS.get(), bow) > 0) {
            if (player.getProjectile(bow).isEmpty()) {
                player.startUsingItem(event.getHand());
                event.setAction(InteractionResultHolder.consume(bow));
            }
        }
    }

    @SubscribeEvent
    public static void onArrowLoose(ArrowLooseEvent event) {
        ItemStack bow = event.getBow();
        Player player = event.getEntity();
        Level level = player.level();
        if (bow.getItem() instanceof BowItem && EnchantmentHelper.getItemEnchantmentLevel(Ethereal_shots.ETHEREAL_SHOTS.get(), bow) > 0) {
            if (!player.getAbilities().instabuild && player.getProjectile(bow).isEmpty()) {
                event.setCanceled(true);
                if (!level.isClientSide) {
                    EtherealArrowEntity etherealArrow = new EtherealArrowEntity(level, player);
                    float velocity = BowItem.getPowerForTime(event.getCharge()) * 3.0F;
                    etherealArrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity, 1.0F);
                    level.addFreshEntity(etherealArrow);
                }
                bow.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
            }
        }
    }
}