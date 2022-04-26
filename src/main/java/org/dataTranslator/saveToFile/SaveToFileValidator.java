package org.dataTranslator.saveToFile;

import org.dataTranslator.*;

public class SaveToFileValidator implements DataValidator {
    @Override
    public boolean validate(String[] data) {
        return data != null && data.length == 1 && !data[0].isBlank();
    }
}
