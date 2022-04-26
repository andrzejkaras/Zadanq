package org.dataTranslator.addWater;

import org.dataTranslator.*;

public class AddWaterValidator implements DataValidator {
    @Override
    public boolean validate(String[] data) {
        return data != null && data.length == 2 && !data[0].isBlank() && Double.parseDouble(data[1]) > 0;
    }
}
