package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>(); //zbiór przyjaciół

    public ForumUser(final String username, final String realName,
                     final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;
        ForumUser forumUser = (ForumUser) o;
        return username.equals(forumUser.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public Set<String> getLocationsOfFriends() { //zwraca zbiór lokalizacji przyjaciół
        return friends.stream() //tworzy strumień kolekcji (Set zawierający obiekty typu ForumUser)
                .map(friend -> friend.getLocation()) //zamienia obiekty ForumUser na obiekty typu String
                .collect(Collectors.toSet()); //tworzenie kolekcji wynikowej typu Set
    }

    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream() //tworzenie i uruchomienie strumienia dla kolekcji friends (lista przyjaciół)
                .flatMap(user -> user.getFriends().stream()) //spłaszczenie strumienia; dla usera pobieramy jego listę przyjaciół
                // i przekazujemy ją w postaci nowe strumienia do dalszych operacji (lista przyjaciół przyjaciół)
                .filter(user -> user != this) //wykluczamy odwołania do samych siebie
                .map(ForumUser::getLocation) //dalej przekazujemy tylko lokalizacje przyjaciół
                .collect(Collectors.toSet()); //wyniki składamy do kolekcji typu Set
    }
}
