package oop;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String userName;
    private String password;
    private boolean isLocked = true;
    private List<Entry> entries = new ArrayList<>();

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlockDiary(String password) {
        boolean isCorrectPassword = password.equals(this.password);
        if (isCorrectPassword) isLocked = false;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public void createEntry(String title, String body) {
        Entry newGist = new Entry(title, body);
        entries.add(newGist);
    }

    public int countGist() {
        return entries.size();
    }

    public Entry findEntryById(int id) {
        Entry gist = entries.get(id);
        return gist;
    }

    public void deleteEntry(int id) {
        entries.remove(id);
    }
}
