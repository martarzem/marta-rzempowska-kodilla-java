package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> par = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getBirthDate(), LocalDate.now()).getYears() >= 20)
                //period.between(data startowa, data końcowa(bliższa dzisiejszemu dniu);
                // metoda zwraca różnicę lat, miesięcy i dni między podanymi datami
                // przy zwykłym odejmowaniu dat otrzymujemy porównanie tylko roku (bez dokładności co do dnia)
                .filter(forumUser -> forumUser.getPostsPublicated() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        par.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .forEach(System.out::println);
    }
}