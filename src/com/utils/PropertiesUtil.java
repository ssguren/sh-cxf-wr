package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {

	protected static final Logger log = Logger.getLogger(PropertiesUtil.class);

	public static Properties getProperties(String configFile) {
		return getProperties(configFile, null);
	}

	public static Properties getProperties(String configFile, String charsetName) {
		Properties prop = new Properties();
		InputStream is = PropertiesUtil.class.getClassLoader()
				.getResourceAsStream(configFile);

		if (is == null) {
			is = PropertiesUtil.class.getResourceAsStream(configFile);
			if (is == null)
				try {
					is = new FileInputStream(configFile);
				} catch (FileNotFoundException e) {
					log.fatal("Config File not found: " + configFile);
					log.error(e);
					log.error(MiscUtil.traceInfo(e));
				}
		}

		if (is != null) {
			try {
				prop.load(new InputStreamReader(is,
						charsetName == null ? "UTF-8" : charsetName));
			} catch (IOException e) {
				log.fatal("Config File read error: " + configFile);
				log.error(MiscUtil.traceInfo(e));
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					log.error(MiscUtil.traceInfo(e));
				}
			}
		}

		return prop;
	}
}
