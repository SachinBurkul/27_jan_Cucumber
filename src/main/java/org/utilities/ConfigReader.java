package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public Properties initProp() {
		FileInputStream fis;
		Properties prop;
		try {
			fis = new FileInputStream("./src/test/resources/org/config/Config.properties");
			prop = new Properties();
			prop.load(fis);
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}