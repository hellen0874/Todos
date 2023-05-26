package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos(); // создали хранитель задач

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);  // закинули туда все задачи

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos(); // создали хранитель задач

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);  // закинули туда все задачи

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindFewTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos(); // создали хранитель задач

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);  // закинули туда все задачи

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos(); // создали хранитель задач

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);  // закинули туда все задачи

        Task[] expected = {};
        Task[] actual = todos.search("позвонить");
        Assertions.assertArrayEquals(expected, actual);

    }

}
