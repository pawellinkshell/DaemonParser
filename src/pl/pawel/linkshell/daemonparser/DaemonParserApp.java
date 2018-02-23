package pl.pawel.linkshell.daemonparser;


import pl.pawel.linkshell.simpleapp.Application;
import pl.pawel.linkshell.simpleapp.annotation.Runner;

@Runner
public final class DaemonParserApp {

    public static void main(String[] args) {
        Application.run(DaemonParserApp.class, args);
    }

}
