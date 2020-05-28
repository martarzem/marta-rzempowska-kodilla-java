package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

//reprezentuje tablicę z zadaniami
/* początkowo
public final class Board {
    final private String name;
    final private Set<TasksList> lists = new HashSet<>();

    public Board(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for(TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }
}

 */

/* klonowanie płytkie
//wersja nadająca się do klonowania
public final class Board extends Prototype { //nadaje się do klonowania
    private String name; //usuwamy final
    private final Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) { //setter, by móc ustawić nową wartość
        this.name = name;               //pola po sklonowaniu obiektu
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for(TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    //metoda wykonująca płytkie klonowanie obiektu klasy Board
    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board)super.clone();
    }
}

 */

// KLONOWANIE GŁĘBOKIE
public final class Board extends Prototype {
    private String name;
    private Set<TasksList> lists = new HashSet<>(); //usuwany private

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws
            CloneNotSupportedException {
        return (Board) super.clone();
    }

    //po wykonaniu płytkiego klonowania, w pętlach dla każdej listy i każdego obiektu
    // dla każdego zadania tworzony jest nowy obiekt typu Task, a dla listy - typu TasksList
    //klonowana jest całą struktura
    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board) super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for (Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }
}