package org.dataTranslator.saveToFile;

import org.commons.*;
import org.dataTranslator.*;

public class SaveToFileParser implements InputParser<SaveToFileData> {
    @Override
    public SaveToFileData parse(String[] data) {
        return new SaveToFileData(data[0]);
    }
}
