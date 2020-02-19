package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private int userID;
    private String username;
    private char sex;
    private LocalDate birthDate;
    private int postsPublicated;

    public ForumUser(int userID, String username, char sex, LocalDate birthDate, int postsPublicated) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsPublicated = postsPublicated;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsPublicated() {
        return postsPublicated;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postsNumber=" + postsPublicated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        return userID == forumUser.userID;
    }

    @Override
    public int hashCode() {
        return userID;
    }
}
