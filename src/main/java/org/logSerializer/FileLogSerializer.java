package org.logSerializer;

import org.actionLog.*;

import java.io.*;
import java.util.*;

public class FileLogSerializer implements LogSerializer {

    @Override
    public boolean save(List<LogEntry> entryLog, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (var entry: entryLog) {
                String entryAsString = entry.toString();
                writer.write(entryAsString + "\n");
            }

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
