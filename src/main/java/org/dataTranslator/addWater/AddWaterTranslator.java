package org.dataTranslator.addWater;

import org.commons.AddWaterData;
import org.dataTranslator.*;

public class AddWaterTranslator implements DataTranslator<AddWaterData> {
    private final DataValidator validator;
    private final InputParser<AddWaterData> inputParser;

    public AddWaterTranslator(DataValidator validator, InputParser<AddWaterData> inputParser) {
        this.validator = validator;
        this.inputParser = inputParser;
    }

    @Override
    public AddWaterData translate(String commandLine) {
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
