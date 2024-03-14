package org.example.patterncommand.apis;

import org.example.patterncommand.cmd.Command;
import org.example.patterncommand.cmd.CommandFactory;
import org.example.patterncommand.enums.MatchType;
import org.example.patterncommand.receiver.PartialMatchDeleter;
import org.example.patterncommand.receiver.PerfectMatchDeleter;
import org.example.patterncommand.tag.TagManager;

import java.util.regex.Pattern;

public class DeleteTagsApi {

    public void deleteTags(String name, MatchType matchType){
        Command command = null;
        if(matchType.equals(MatchType.PERFECT)){
            command = CommandFactory.getPerfectMatchDeleteCommand(name, new PerfectMatchDeleter());
        }else if( matchType.equals(MatchType.PARTIAL)){
            command = CommandFactory.getPartialMatchDeleteCommand(Pattern.compile(name), new PartialMatchDeleter());
        }else {
            throw new IllegalArgumentException("invalid match type");
        }
        new TagManager(command).changeTags();
    }
}
