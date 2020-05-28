package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {

    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();

        /*
        String movie = collection.get(0);
        System.out.println(movie);
    // do tego momentu wszystko działą poprawnie

        // próbujemy wyciągnąć 3. element -> pojawi się błąd
        String anotherMovie = collection.get(2);
        System.out.println(anotherMovie);
         */

        //aby się ustrzec przed błedem można skorzystać z metody size()
        if (collection.size() > 2) {
            String movie = collection.get(0);
            System.out.println(movie);

            String anotherMovie = collection.get(2);
            System.out.println(anotherMovie);
        }
    }
}
