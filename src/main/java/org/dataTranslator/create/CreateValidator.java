package org.dataTranslator.create;

import org.dataTranslator.*;

public class CreateValidator implements DataValidator {
    @Override
    public boolean validate(String[] data) {
        if (data == null || data.length != 2) {
            return false;
        }

        String name = data[0];
        String capacity = data[1];

        return name != null && capacity != null;
    }
}
