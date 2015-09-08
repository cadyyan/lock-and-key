package com.cadyyan.lockAndKey;

import com.cadyyan.lockAndKey.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LockAndKey.MODID, name = LockAndKey.NAME, version = LockAndKey.VERSION)
public class LockAndKey
{
	public static final String MODID   = "lockAndKey";
	public static final String NAME    = "Lock And Key";
	public static final String VERSION = "1.0.0"; // TODO: pull this from the build.gradle file

	@Instance(MODID)
	public static LockAndKey instance;

	@SidedProxy(clientSide = "com.cadyyan.lockAndKey.proxy.CommonProxy", serverSide = "com.cadyyan.lockAndKey.proxy.CommonProxy")
	public static IProxy proxy;

	public static final CreativeTab CREATIVE_TAB = new CreativeTab();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.registerItems();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
