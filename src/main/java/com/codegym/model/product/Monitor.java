package com.codegym.model.product;




public class Monitor {
    private String screenSize;
    private String resolution;
    private String scanFrequency;
    private String aspectRatio;
    private String connector;
    private String panels;

    public Monitor() {
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScanFrequency() {
        return scanFrequency;
    }

    public void setScanFrequency(String scanFrequency) {
        this.scanFrequency = scanFrequency;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }
}
