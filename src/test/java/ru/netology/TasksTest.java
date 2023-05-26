package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    // Для SimpleTask
    @Test
    public void testMatchesForSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesForSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);
    }

    // Для Epic
    @Test
    public void testMatchesForEpicTrue() {
        String[] subtasks = {"Майонез", "Сыр", "Колбаса"};
        Epic epic = new Epic(11, subtasks);
        boolean actual = epic.matches("Сыр");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesForEpicFalse() {
        String[] subtasks = {"Майонез", "Сыр", "Колбаса"};
        Epic epic = new Epic(11, subtasks);
        boolean actual = epic.matches("Молоко");
        Assertions.assertFalse(actual);
    }
    // Для Meeting
    @Test
    public void testMatchesForMeetingTopicTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("версии");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesForMeetingProjectTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Приложение");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesForMeetingFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Хлеб");
        Assertions.assertFalse(actual);
    }

}
