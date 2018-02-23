package pl.pawel.linkshell.daemonparser.flow.logic.controller;

import pl.pawel.linkshell.simpleapp.annotation.Controller;
//import pl.pawel.linkshell.simpleapp.command.Command;
import pl.pawel.linkshell.daemonparser.flow.logic.service.ParserService;

import java.util.Arrays;

/**
 * Created by pawellinkshell on 18.02.2018.
 */
@Controller
public class ParserController {

    private ParserService service;

    public ParserController() {
        this.service = new ParserService();
    }

    public void run() {
        service.watchDirectory();
    }

    public void quit(String[] args) {
//        if (!isExternalCommandExecuted(args)) {
//            if (isClosed) {
//                System.out.println("Thank you");
//                System.exit(0);
//            }
//            throw new IllegalThreadStateException(
//                    "Daemon was not close!! Ups we gona have ghost thread");
//        } else {
//            System.out.println("Application was run with external command");
//
//            // TODO Handle external command
//        }
    }

    private boolean isExternalCommandExecuted(String[] args) {
        if (args.length > 0) {
            String command = Arrays.toString(args);

//            if (Command.isQuit(command)) {
//                return true;
//            }
        }
        return false;
    }

}