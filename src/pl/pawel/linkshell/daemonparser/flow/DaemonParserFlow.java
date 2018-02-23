package pl.pawel.linkshell.daemonparser.flow;

import pl.pawel.linkshell.simpleapp.command.Command;
import pl.pawel.linkshell.simpleapp.flow.ApplicationFlow;

public final class DaemonParserFlow extends ApplicationFlow{

  @Override
  protected boolean prepare(String args) {
    boolean isPrepared = true;//super.prepare(args);

    return isPrepared;
  }

  @Override
  public boolean run() {
    Command.clearConsole();
    return false;
  }
}
