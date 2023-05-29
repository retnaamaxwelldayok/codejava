package oop;

public class Entry {
    private String title;
    private String body;
    private int id = 0;

    public Entry(String title, String body) {
        this.title = title;
        this.body = body;
        id++;
    }

    public Object getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
