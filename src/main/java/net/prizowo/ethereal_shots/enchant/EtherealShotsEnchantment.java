package net.prizowo.ethereal_shots.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class EtherealShotsEnchantment extends Enchantment {

    public EtherealShotsEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return 10 + (level - 1) * 10;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() == Items.BOW;
    }

    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }
}