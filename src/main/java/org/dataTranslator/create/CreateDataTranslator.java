package org.dataTranslator.create;

import org.commons.*;
import org.dataTranslator.*;

public class CreateDataTranslator implements DataTranslator<CreateContainerData> {
    private final DataValidator validator;
    private final InputParser<CreateContainerData> inputParser;

    public CreateDataTranslator(DataValidator validator, InputParser<CreateContainerData> inputParser) {
        this.validator = validator;
        this.inputParser = inputParser;
    }

    public CreateContainerData translate(String commandLine) {
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
