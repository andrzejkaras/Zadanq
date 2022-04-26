package org.commandHandler.saveToFile;

public class SaveToFileCommand {
    private String filename;

    public SaveToFileCommand(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
