package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	FileInputStream fis;
	Properties prop;
	public  ConfigReader() {
    	File f = new File("./config.properties");
    	
    	try {
			 fis = new FileInputStream(f);
			
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getbrowserValue() {
		String br=prop.getProperty("browser");
		return br;
	}
	public String getappUrl() {
		String apu=prop.getProperty("appUrl");
		return apu;
	}
	public String getuserName() {
		String uname=prop.getProperty("userName");
		return uname;
	}
	public String getpassword() {
		String pass=prop.getProperty("password");
		return pass;
	}
	public String getchromeDriverKey() {
		String cdk=prop.getProperty("chromeDriverKey");
		return cdk;
	}
	public String getfirefoxDriverKey() {
		String fdk=prop.getProperty("firefoxDriverKey");
		return fdk;
	}
	public String getchromeDriverPath() {
		String cdp=prop.getProperty("chromeDriverPath");
		return cdp;
	}
	public String getfirefoxDriverPath() {
		String fdp=prop.getProperty("firefoxDriverPath");
		return fdp;
	}
	public String gettestDataFile() {
		String tdf=prop.getProperty("testDataFile");
		return tdf;
	}
	}

