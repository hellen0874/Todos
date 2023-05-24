package ru.netology;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.project = project;
        this.topic = topic;
        this.start = start;// заполнение своих полей
    }

    public String getTopic() {
        return topic;
    }

    public String getStart() {
        return start;
    }

    public String getProject() {
        return project;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}
