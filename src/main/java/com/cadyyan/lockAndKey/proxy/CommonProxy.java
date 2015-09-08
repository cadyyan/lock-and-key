package com.cadyyan.lockAndKey.proxy;

import com.cadyyan.lockAndKey.LockAndKey;
import com.cadyyan.lockAndKey.item.LockAndKeyItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public class CommonProxy implements IProxy
{
	@Override
	public void registerItems()
	{
		registerItem(LockAndKeyItems.LOCK);
	}

	protected void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName(), LockAndKey.MODID);
	}
}
