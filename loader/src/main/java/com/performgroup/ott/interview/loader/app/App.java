package com.performgroup.ott.interview.loader.app;


import com.performgroup.ott.interview.loader.commands.Command;
import com.performgroup.ott.interview.loader.commands.CommandFactory;

import java.io.IOException;

/**
 * Created by lukasz.gawron on 17/06/16.
 */
public class App {

    public static final int EXIT_STATUS_CODE = 1;

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("Lack of required parameters");
            System.exit(EXIT_STATUS_CODE);
        }
        try {
            Command command = CommandFactory.create(args[0], args);
            command.execute();
        } catch (Exception e) {
            System.err.println("Error during processing " + e.getMessage());
            System.exit(EXIT_STATUS_CODE);
        }
    }
}
