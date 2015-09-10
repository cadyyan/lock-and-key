package com.cadyyan.lockAndKey.handler;

import com.cadyyan.lockAndKey.LockAndKey;
import com.cadyyan.lockAndKey.Settings;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ConfigurationHandler
{
	public static Configuration config;

	public static void init(File configFile)
	{
		config = new Configuration(configFile);

		loadConfiguration();
	}

	public static void loadConfiguration()
	{
		Settings.Locks.whitelistEnabled = config.getBoolean("locks.whitelist.enable", Configuration.CATEGORY_GENERAL, false, "Enable or disable the block whitelist for locks");
		Settings.Locks.blockWhitelist = getBlockList(
				config.getStringList(
						"locks.whitelist.blocks",
						Configuration.CATEGORY_GENERAL,
						new String[] {GameRegistry.findUniqueIdentifierFor(Blocks.chest).toString()},
						"The list of blocks that are allowed to have locks added to them"
				)
		);

		Settings.Locks.blacklistEnabled = config.getBoolean("locks.blacklist.enable", Configuration.CATEGORY_GENERAL, false, "Enable or disable the block blacklist for locks");
		Settings.Locks.blockBlacklist = getBlockList(
				config.getStringList(
						"locks.blacklist.blocks",
						Configuration.CATEGORY_GENERAL,
						new String[] {},
						"The list of blocks that are not allowed to have locks added to them"
				)
		);

		if (config.hasChanged())
			config.save();
	}

	@SuppressWarnings("unused")
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(LockAndKey.MODID))
			ConfigurationHandler.loadConfiguration();
	}

	private static Set<Block> getBlockList(String[] blockList)
	{
		Set<Block> blocks = new HashSet<Block>();

		for (String blockName : blockList)
		{
			Block block = Block.getBlockFromName(blockName);

			if (block == null)
			{
				LockAndKey.LOG.warn("Invalid block name {}, skipping", blockName);
				continue;
			}

			blocks.add(block);
		}

		return blocks;
	}
}
