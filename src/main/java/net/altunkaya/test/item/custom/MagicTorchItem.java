package net.altunkaya.test.item.custom;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class MagicTorchItem extends Item {
    public MagicTorchItem (Settings settings){
        super(settings.maxDamage(64));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos originalPos = context.getBlockPos();
        Direction face=context.getSide();
        BlockPos torchPos = originalPos.offset(face);

        if(world.getBlockState(torchPos).isAir()){
            if(!world.isClient()){
                world.setBlockState(torchPos, Blocks.TORCH.getDefaultState());

                context.getStack().damage(1,((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));


                world.playSound(
                        null,
                        originalPos,
                        SoundEvents.ITEM_FIRECHARGE_USE,
                        SoundCategory.BLOCKS,
                        1.0f,
                        1.3f
                );
                return ActionResult.SUCCESS;

            }
            else{
                for (int i = 0; i <5; i++){
                    world.addParticle(
                            ParticleTypes.FLAME,
                            torchPos.getX() + 0.5,
                            torchPos.getY() + 0.5,
                            torchPos.getZ() + 0.5,
                            0.0,0.0,0.0
                    );
                }


            }

        }


    return ActionResult.PASS;


    }
}
