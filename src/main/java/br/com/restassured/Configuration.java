package br.com.restassured;

public class Configuration {

    private ReadProperties readProperties;

    public Configuration() {
        readProperties = new ReadProperties();
    }

    public String getBaseUrl() {
        return readProperties.getValue("base.url");
    }

    public String getBasePath() {
        return readProperties.getValue("base.path");
    }
}
