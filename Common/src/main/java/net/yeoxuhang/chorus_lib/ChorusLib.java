package net.yeoxuhang.chorus_lib;

import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChorusLib {

	public static final String MOD_ID = "chorus_lib";
	public static final String MOD_NAME = "ChorusLib";
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
	public static void init() {
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