package com.cadyyan.lockAndKey.item;

import com.cadyyan.lockAndKey.LockAndKey;
import com.cadyyan.lockAndKey.Settings;
import com.cadyyan.lockAndKey.api.item.ILock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
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
		Block block = blockState.getBlock();

		if (Settings.Locks.whitelistEnabled && !Settings.Locks.blockWhitelist.contains(block))
			return false;
		else if (Settings.Locks.blacklistEnabled && Settings.Locks.blockBlacklist.contains(block))
			return false;

		// TODO: check if we even support this block type

		LockAndKey.LOG.info("===== Lock clicked on block =====");

		return true;
	}
}
