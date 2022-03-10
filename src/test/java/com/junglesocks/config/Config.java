package com.junglesocks.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Config  {

    public static FileInputStream fileInput;
    public static Properties props;
    public static String filePathDex = "src/test/resources/config/test.props";
    public static String classPathRoot = new File(System.getProperty("user.dir")).getAbsolutePath();
    public static String filePath = classPathRoot + File.separator + filePathDex;
    public final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static void loadPropertiesFiles() throws IOException {
        try {
            File file = new File(filePath);
            fileInput = new FileInputStream(file);
            props = new Properties();
            props.load(fileInput);
            log.info("Properties loaded from file \"" + filePath + "\"");
        } catch (Exception e) {
            log.info("ERROR: Properties NOT loaded from file \"" + filePath + "\"");
        }
    }

    public String getBaseUrl() {
        try {
            loadPropertiesFiles();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return props.getProperty("site.url");
    }
}
