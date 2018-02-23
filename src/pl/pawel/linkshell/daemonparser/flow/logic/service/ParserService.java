package pl.pawel.linkshell.daemonparser.flow.logic.service;

import pl.bekz.parserNumber.ParserNumberRunner.ParserNumberRunner;
import pl.pawel.linkshell.daemonparser.flow.data.constant.Constant;
import pl.pawel.linkshell.daemonparser.flow.data.model.ParserDaemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Created by pawellinkshell on 18.02.2018.
 */
public class ParserService {

    private ParserDaemon parserDaemon;
    private boolean watching;

    public ParserService() {
        this.parserDaemon = new ParserDaemon(Constant.Name.DAEMON);
        this.watching = false;
    }

    public void watchDirectory() {
        Path listeningPath = getListeningPath();
        FileSystem fileSystem = listeningPath.getFileSystem();

        try {
            do {
                WatchService watcher = fileSystem.newWatchService();
                listeningPath.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

                listenFile(listeningPath, watcher);
            } while (watching);

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    private void listenFile(Path listeningPath, WatchService watcher) throws InterruptedException {
        WatchKey watchKey = watcher.take();

        List<WatchEvent<?>> events = watchKey.pollEvents();
        for (WatchEvent event : events) {

            Path file = ((WatchEvent<Path>)event).context();
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                System.out.println("Created: " + event.context().toString());

            }
            if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                System.out.println("Delete: " + event.context().toString());
            }
            if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                System.out.println("Modify: " + event.context().toString());


                String fileName = listeningPath + "\\" + file.toString();

                String wholeInput = "";
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

                    String readedLine;
                    while(( readedLine = br.readLine()) != null) {
                        wholeInput += readedLine;
                    }

                } catch (IOException e) {
                    // NO operation
                }

                String[] strings = {wholeInput};
                ParserNumberRunner.main(strings);
                this.watching = true;
            }
        }
    }

    private Path getListeningPath() {
        String currentPath = null;
        try {
            currentPath = new java.io.File( "." ).getCanonicalPath();
            currentPath += Constant.Path.INPUT;
        } catch (IOException e) {
            e.printStackTrace();
        }

        //define a folder root
        return Paths.get(currentPath);
    }
}
