package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BoardTestSuite {
    public Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("p" +
                "rojectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() { //sprawdza, czy w Board zostały zdefiniowane 3 listy
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() { //szukamy zadań przypisanych do developer1 wśród wszystkich list
        //Given
        Board project = prepareTestData();
        //When
        User user = new User("developer1", "John Smith"); //tworzymy obiekt klasy User
        List<Task> tasks = project.getTaskLists().stream() //uruchamiamy strumień na kolekcji otrzymanej z getTastLists()
                .flatMap(l -> l.getTasks().stream()) //spłaszczamy, bo mamy strumień list zadań, a chcemy mieć strumień zadań
                .filter(t -> t.getAssignedUser().equals(user)) //filtrujemy i dalej puszczamy tylko co, co ma w username "usera"
                .collect(toList()); //tworzymy kolekcję wynikową; zapisywana jest do zmiennej tasks
        //Then
        Assert.assertEquals(2, tasks.size()); //sprawdza, czy znaleziono dokładnie 2 takie zadania
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser()); // obie sprawdzają, czy na pewno username = user
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() { /*
        szukamy zadań przeterminowanych; wiemy, że będą albo na listach
        ToDo albo na listach InProgress
        Given
        */
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>(); //tworzymy roboczą listę zadań
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress")); //przypisujemy do niej 2 puste listy z niewykonanymi zadaniami
        List<Task> tasks = project.getTaskLists().stream() //uruchamiamy strumień na kolekcji getTaskList()
                .filter(undoneTasks::contains) //zostają tylke te, co mają niewykonane zadania; referencja do metody
                .flatMap(tl -> tl.getTasks().stream()) //spłaszczamy do listy zadań, zamiast mieć listę list zadań
                .filter(t -> t.getDeadline().isBefore(LocalDate.now())) //pobiera deadliny, dalej idą te, których data
                // przekroczyła systemową obecną
                .collect(toList());

        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test //zadania wykonywane co najmniej od 10 dni; wiemy, że będą w liście InProgress; trzeba porównać
    // datę getCreated z bieżącą datą systemową
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>(); //robocza lista, zawierająca listy zadań w trakcie realizacji
        inProgressTasks.add(new TaskList("In progress")); //zawiera jedną listę zadań
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains) //zostają tylko te, które są w trakcie realizacji
                .flatMap(tl -> tl.getTasks().stream()) //spłąszczamy z listy list zadań do listy zadań
                .map(t -> t.getCreated())//przekształcamy z zadań do strumienia dat, kiedy zostały zadania zaczęte
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0) //zwraca -1, gdy data jest mniejsza,
                // 0 gdy są równe, 1 gdy jest większa
                .count();

        //Then
        Assert.assertEquals(2, longTasks);
    }

    //wersja z average()
    @Test
    public void testAddTaskListAverageWorkingOnTasksAvg() {
        Board project = prepareTestData();

        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        double startedTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(task -> task.getTasks().stream())
                .mapToDouble(date -> ChronoUnit.DAYS.between(date.getCreated(), LocalDate.now()))//liczy
                //różnicę między obecną datą a datą podaną; do average() trzeba zamienić na double (mapToDouble)
                .average()
                .orElse(0);

        Assert.assertEquals(10.0, startedTasks, 0.01);
    }

    //wersja z liczeniem dni i zadań
    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        Board project = prepareTestData();

        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long days = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(task -> task.getTasks().stream())
                .map(date -> ChronoUnit.DAYS.between(date.getCreated(), LocalDate.now()))
                .reduce(0L, (sum,current) -> sum = sum + current); //mamy typ Long z wyższej linijki, dlatego
        //inicjalizacyjna liczba musi być też typu long (0L)
        long tasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(task -> task.getTasks().stream())
                .count();

        double result = days/tasks;

        Assert.assertEquals(10.0, result, 0.01);
    }
}