package net.altunkaya.test.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LuckyStoneItem extends Item {
    public LuckyStoneItem(Settings settings){
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if(!world.isClient()) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,
                100,
                1
        ));
        user.sendMessage(Text.literal("You feel lucky!"), false);

        }

        user.getItemCooldownManager().set(this, 100);
        return TypedActionResult.success(stack);
    }

}