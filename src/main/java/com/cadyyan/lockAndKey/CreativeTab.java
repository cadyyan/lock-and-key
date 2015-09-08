package com.cadyyan.lockAndKey;

import com.cadyyan.lockAndKey.item.LockAndKeyItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs
{
	public CreativeTab()
	{
		super(LockAndKey.NAME);
	}

	@Override
	public Item getTabIconItem()
	{
		return LockAndKeyItems.LOCK;
	}
}
