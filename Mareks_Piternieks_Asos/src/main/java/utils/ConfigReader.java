package utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

  private Properties properties;
  private final String propertyFilePath= "src" + File.separator + "main" + File.separator + "resources" + File.separator + "configs" + File.separator + "configuration.properties";

  public ConfigReader(){
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(propertyFilePath));
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
    }
  }

  public String getEnvironment(){
    String envName = properties.getProperty("environment.name");
    if(envName != null) return envName;
    else throw new RuntimeException("environment.name not specified in the Configuration.properties file.");
  }


  public String getApplicationUrl() {
    String url = properties.getProperty("url");
    if(url != null) return url;
    else throw new RuntimeException("url not specified in the Configuration.properties file.");
  }

  public String getPropertyValue(String propertyName){
    String returnValue = properties.getProperty(propertyName);
    if(returnValue != null) return returnValue;
    else throw new RuntimeException(propertyName + " not specified in the Configuration.properties file.");
  }
}
