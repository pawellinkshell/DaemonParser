package pl.pawel.linkshell.daemonparser.flow.data.constant;

/**
 * Created by pawellinkshell on 18.02.2018.
 */
public final class Constant {

    public interface Name {
        String DAEMON = "ParserDaemon";
    }

    public interface Path {
        String RESOURCES = "\\resources";
        String INPUT = RESOURCES + "\\input";
    }

    public interface File {
        String INPUT = "in.txt";
    }

}
