package org.operationsReceiver;

public class ConsoleReader {

    public String read() {
        System.out.print("Enter operation: ");

        try {
            String commandLine = System.console().readLine();

            if (commandLine != null && (commandLine.isBlank() || commandLine.isEmpty())) {
                return null;
            }

            return commandLine;
        } catch (Throwable t) {
            return null;
        }
    }
}
