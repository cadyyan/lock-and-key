package com.cadyyan.lockAndKey.proxy;

import com.cadyyan.lockAndKey.LockAndKey;
import com.cadyyan.lockAndKey.handler.ConfigurationHandler;
import com.cadyyan.lockAndKey.item.LockAndKeyItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public class CommonProxy implements IProxy
{
	@Override
	public void registerEventHandlers()
	{
		LockAndKey.LOG.trace("Registering event handlers");

		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
	}

	@Override
	public void registerItems()
	{
		LockAndKey.LOG.trace("Registering items");

		registerItem(LockAndKeyItems.LOCK);
	}

	protected void registerItem(Item item)
	{
		LockAndKey.LOG.trace("Registering item: {}", item.getUnlocalizedName());

		GameRegistry.registerItem(item, item.getUnlocalizedName(), LockAndKey.MODID);
	}
}
