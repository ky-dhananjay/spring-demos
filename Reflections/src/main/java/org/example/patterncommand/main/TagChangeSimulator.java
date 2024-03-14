package org.example.patterncommand.main;

import org.example.patterncommand.apis.DeleteTagsApi;
import org.example.patterncommand.enums.MatchType;

public class TagChangeSimulator {
    public static void main(String[] args) {
        new DeleteTagsApi().deleteTags("math.*", MatchType.PARTIAL);
    }
}
