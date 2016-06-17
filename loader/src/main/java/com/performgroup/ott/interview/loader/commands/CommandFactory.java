package com.performgroup.ott.interview.loader.commands;

/**
 * Created by lukasz on 17/06/16.
 */
public class CommandFactory {

    public static final String LOAD_COMMAND_LINE_NAME = "load";

    public static Command create(String commandName, String[] options) {
        if (LOAD_COMMAND_LINE_NAME.equals(commandName)) {
            return new LoadGraphCommand(options);
        } else {
            throw new IllegalArgumentException("Not supported command provided " + commandName);
        }
    }
}
