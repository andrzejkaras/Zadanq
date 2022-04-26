package org.dataTranslator.addWater;

import org.commons.AddWaterData;
import org.dataTranslator.*;

public class AddWaterParser implements InputParser<AddWaterData> {
    @Override
    public AddWaterData parse(String[] data) {
        return new AddWaterData(data[0], Double.parseDouble(data[1]));
    }
}
