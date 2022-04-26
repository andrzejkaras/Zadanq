package org.commons;

public class SaveToFileData {
    private String filename;

    public SaveToFileData(String fileName) {
        this.filename = fileName;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
