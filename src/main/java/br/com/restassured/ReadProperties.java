package br.com.restassured;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class ReadProperties {

    Logger logger = LogManager.getLogger(ReadProperties.class);

    private Properties properties;

    ReadProperties() {
        properties = new Properties();
    }

    String getValue(String key) {
        try {
            properties.load(new FileReader("src/test/resources/config/configuration.properties"));
        } catch (IOException e) {
            logger.fatal("Erro ao carregar arquivo de propriedade", e);
        }

        return properties.getProperty(key);
    }
}
