package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(11, "John Smith", 'M', LocalDate.of(1998, 2, 12), 10));
        userList.add(new ForumUser(22, "Dorothy Newman", 'F', LocalDate.of(1990, 7, 1), 34));
        userList.add(new ForumUser(33, "John Wolkowitz", 'M', LocalDate.of(1975, 8, 4), 0));
        userList.add(new ForumUser(44, "Lucy Riley", 'F', LocalDate.of(1988, 5, 21), 3));
        userList.add(new ForumUser(55, "Owen Rogers", 'M', LocalDate.of(1968, 11, 17), 1));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
