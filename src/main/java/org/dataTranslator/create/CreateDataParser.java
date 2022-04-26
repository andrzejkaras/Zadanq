package org.dataTranslator.create;

import org.commons.*;
import org.dataTranslator.*;

public class CreateDataParser implements InputParser<CreateContainerData> {
    @Override
    public CreateContainerData parse(String[] data) {
        return new CreateContainerData(data[0], Double.parseDouble(data[1]));
    }
}
