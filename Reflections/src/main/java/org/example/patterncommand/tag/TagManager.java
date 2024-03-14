package org.example.patterncommand.tag;

import org.example.patterncommand.cmd.Command;

public class TagManager {

    private final Command command;

    public TagManager(Command command) {
        this.command = command;
    }

    public void changeTags(){
        this.command.execute();
    }
}
