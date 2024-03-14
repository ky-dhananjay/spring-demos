package org.example.patternobserver;

public class TestObservers {
    public static void main(String[] args) {
        DatabaseSubject s = new DatabaseSubject();
        Observer archiver = new ArchiveObserver();
        Observer client = new ClientObserver();
        Observer boss = new BossObserver();
        // register the observers
        s.registerObserver(archiver);
        s.registerObserver(client);
        s.registerObserver(boss);

        // edit the record
        s.editRecord("DELETE", "a user");
    }
}
