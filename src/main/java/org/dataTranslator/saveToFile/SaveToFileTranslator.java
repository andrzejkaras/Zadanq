package org.dataTranslator.saveToFile;

import org.commons.*;
import org.dataTranslator.*;

public class SaveToFileTranslator implements DataTranslator<SaveToFileData> {
    private final DataValidator validator;
    private final InputParser<SaveToFileData> inputParser;

    public SaveToFileTranslator(DataValidator validator, InputParser<SaveToFileData> inputParser) {
        this.validator = validator;
        this.inputParser = inputParser;
    }

    @Override
    public SaveToFileData translate(String commandLine) {
        String data = commandLine.split(":")[1];

        if (data == null || data.isBlank()) {
            return null;
        }

        String[] splitData = data.split(";");
        boolean isValid = validator.validate(splitData);

        if (!isValid) {
            return null;
        }

        return inputParser.parse(splitData);
    }
}
