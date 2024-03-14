package org.example.patterncommand.cmd;

import org.example.patterncommand.receiver.PartialMatchDeleter;
import org.example.patterncommand.receiver.PerfectMatchDeleter;

import java.util.regex.Pattern;

public class CommandFactory {

    public static Command getPartialMatchDeleteCommand(Pattern pattern, PartialMatchDeleter partialMatchDeleter){
        return new PartialMatchDeleteCommand(pattern, partialMatchDeleter);
    }
    public static Command getPerfectMatchDeleteCommand(String pattern, PerfectMatchDeleter partialMatchDeleter){
        return new PerfectMatchDeleteCommand(pattern, partialMatchDeleter);
    }
}
