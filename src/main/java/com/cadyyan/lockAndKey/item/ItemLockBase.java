package com.cadyyan.lockAndKey.item;

import com.cadyyan.lockAndKey.LockAndKey;
import com.cadyyan.lockAndKey.api.item.ILock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class ItemLockBase extends LockAndKeyBaseItem implements ILock
{
	public ItemLockBase(String unlocalizedName)
	{
		super(unlocalizedName);

		setMaxStackSize(1);
	}

	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world,
	                              BlockPos blockPos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
			return false;

		IBlockState blockState = world.getBlockState(blockPos);

		// TODO: this is bad, don't hardcode blocks
		if (!blockState.getBlock().equals(Blocks.chest))
			return false;

		LockAndKey.LOG.info("===== Lock clicked on block =====");

		return true;
	}
}
