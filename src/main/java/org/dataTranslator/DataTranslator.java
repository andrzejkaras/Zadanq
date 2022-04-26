package org.dataTranslator;

public interface DataTranslator<T> {
    T translate(String commandLine);
}
