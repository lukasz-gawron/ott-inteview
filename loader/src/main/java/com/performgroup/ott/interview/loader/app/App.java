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

        System.out.println("Data loader started...");
        if (args.length == 0) {
            System.out.println("Lack of required parameters. Application stopped with error.");
            System.exit(EXIT_STATUS_CODE);
        }
        try {
            Command command = CommandFactory.create(args[0], args);
            command.execute();
            System.out.println("Data loader finished successfully.");
        } catch (Exception e) {
            System.err.println("Application stopped with error: " + e.getMessage());
            System.exit(EXIT_STATUS_CODE);
        }
    }
}
