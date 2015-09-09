package com.cadyyan.lockAndKey;

import com.cadyyan.lockAndKey.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = LockAndKey.MODID, name = LockAndKey.NAME, version = LockAndKey.VERSION)
public class LockAndKey
{
	public static final String MODID   = "lockAndKey";
	public static final String NAME    = "Lock And Key";
	public static final String VERSION = "@MOD_VERSION@";

	@SuppressWarnings("unused")
	@Instance(MODID)
	public static LockAndKey instance;

	@SidedProxy(clientSide = "com.cadyyan.lockAndKey.proxy.CommonProxy", serverSide = "com.cadyyan.lockAndKey.proxy.CommonProxy")
	public static IProxy proxy;

	public static final CreativeTab CREATIVE_TAB = new CreativeTab();

	public static final Logger LOG = LogManager.getLogger(MODID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LOG.trace("Pre-Initialization Phase");

		proxy.registerItems();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		LOG.trace("Initialization Phase");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LOG.trace("Post-Initialization Phase");
	}
}
