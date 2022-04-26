package org.dataTranslator;

public interface InputParser<T> {
    T parse(String[] data);
}
