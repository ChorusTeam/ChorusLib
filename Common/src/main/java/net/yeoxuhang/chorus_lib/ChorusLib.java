package net.yeoxuhang.chorus_lib;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.yeoxuhang.chorus_lib.config.ChorusLibConfig;
import net.yeoxuhang.chorus_lib.util.ChorusLibUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ChorusLib {
	public static ChorusLibConfig CONFIGS;
	private static final Map<Block, Predicate<BlockBehaviour.BlockStateBase>> BLOCKSTATE_IS_REPLACEMENTS = new HashMap<>();
	public static final String MOD_ID = "chorus_lib";
	public static final String MOD_NAME = "ChorusLib";
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
	public static void init() {
	}
	public static void setBlockstateIsReplacements(){
		blockToBlockTagReplacement(Blocks.END_STONE, ChorusLibUtils.BLOCKS.END_STONES);
	}

	public static void blockToBlockTagReplacement(Block block, TagKey<Block> blockTag) {
		BLOCKSTATE_IS_REPLACEMENTS.put(block, state -> state.is(blockTag));
	}

	public static Map<Block, Predicate<BlockBehaviour.BlockStateBase>> getBlockstateIsReplacements() {
		return BLOCKSTATE_IS_REPLACEMENTS;
	}

	public static void setConfig(ChorusLibConfig config) {
		CONFIGS = config;
	}

	public static void logWarning(String msg) {
		LOGGER.warn("ChorusLib: " + msg);
	}
	public static void logInfo(String msg) {
		LOGGER.info("ChorusLib: " + msg);
	}
	public static void logDebug(String msg) {
		LOGGER.debug("ChorusLib: " + msg);
	}
	public static <T> void logDebug(String msg, T loadedService, Class<T> clazz) {
		LOGGER.info("ChorusLib: " + msg, loadedService, clazz);
	}
	public static void logError(String msg) {
		LOGGER.error("ChorusLib: " + msg);
	}
	public static void logError(String msg, Throwable throwable) {
		LOGGER.error("ChorusLib:" + msg, throwable);
	}
}