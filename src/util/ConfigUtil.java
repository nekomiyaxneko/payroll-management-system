package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties prop=new Properties();
	static{
		InputStream is=ConfigUtil.class.getClassLoader()
			.getResourceAsStream("util/dao.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return prop.getProperty(key);
	}
	public static void main(String[] args) {
		System.out.println(ConfigUtil.getValue("UserDao"));
	}
}


