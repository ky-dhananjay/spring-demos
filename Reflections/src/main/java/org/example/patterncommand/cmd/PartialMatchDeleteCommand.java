package org.example.patterncommand.cmd;

import org.example.patterncommand.receiver.PartialMatchDeleter;

import java.util.regex.Pattern;

public class PartialMatchDeleteCommand implements Command{
    private final Pattern pattern;
    private final PartialMatchDeleter partialMatchDeleter;

    public PartialMatchDeleteCommand(Pattern pattern, PartialMatchDeleter partialMatchDeleter) {
        this.pattern = pattern;
        this.partialMatchDeleter = partialMatchDeleter;
    }

    @Override
    public void execute() {
        this.partialMatchDeleter.delete(this.pattern);
    }

}
