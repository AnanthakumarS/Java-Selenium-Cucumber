package com.kindred.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class ConfigProperties {

	static Properties properties = new Properties();
	private static String PLATFORM;
	private static String BROWSER;

	static {
		readProperties();
		String platform = System.getProperty("PLATFORM");
		if (StringUtils.isBlank(platform))
			PLATFORM = properties.getProperty("PLATFORM");
		else
			PLATFORM = platform;

		String browser = System.getProperty("BROWSER");
		if (StringUtils.isBlank(browser))
			BROWSER = properties.getProperty("BROWSER");
		else
			BROWSER = browser;
	}

	private static void readProperties() {
		String filePath = null;
		// create and load default properties
		FileInputStream in = null;
		try {
			filePath = new File(".").getCanonicalPath() + File.separator + "config.properties";
			in = new FileInputStream(filePath);
			properties.load(in);
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @return the pLATFORM
	 */
	public static String getPLATFORM() {
		return PLATFORM;
	}

	/**
	 * @return the bROWSER
	 */
	public static String getBROWSER() {
		return BROWSER;
	}
}
