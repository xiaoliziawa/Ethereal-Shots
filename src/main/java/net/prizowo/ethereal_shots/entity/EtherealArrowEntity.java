package net.prizowo.ethereal_shots.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class EtherealArrowEntity extends AbstractArrow {

    public EtherealArrowEntity(Level level, LivingEntity shooter) {
        super(EntityType.ARROW, shooter, level);
        this.setBaseDamage(this.getBaseDamage() / 3.0);
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        super.onHitEntity(result);
        this.discard();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result) {
        super.onHitBlock(result);
        this.discard();
    }

    @Override
    public boolean shouldRender(double x, double y, double z) {
        return true;
    }
}