package com.cadyyan.lockAndKey.item;

import com.cadyyan.lockAndKey.LockAndKey;
import net.minecraft.item.Item;

public class LockAndKeyBaseItem extends Item
{
	public LockAndKeyBaseItem(String unlocalizedName)
	{
		super();

		setUnlocalizedName(unlocalizedName);
		setCreativeTab(LockAndKey.CREATIVE_TAB);
	}
}
