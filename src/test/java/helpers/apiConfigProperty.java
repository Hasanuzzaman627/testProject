package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class apiConfigProperty {

    public static void updateConfigurationProperty(String filePath, String key, String value) {
        Properties props = new Properties();
        File configFile = new File(filePath);

        if (configFile.exists()) {
            try (FileInputStream in = new FileInputStream(configFile)) {
                props.load(in);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties from: " + filePath, e);
            }
        } else {
            throw new RuntimeException("Configuration file not found: " + configFile.getAbsolutePath());
        }

        props.setProperty(key, value);

        try (FileOutputStream out = new FileOutputStream(configFile)) {
            props.store(out, "Updated " + key + " value");
            System.out.println("Updated '" + key + "' in " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to " + filePath, e);
        }
    }
}
