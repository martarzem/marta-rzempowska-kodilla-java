package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        User peter = new Millenials("Peter Big");
        User steven = new YGeneration("Steven Tall");
        User alex = new ZGeneration("Alex Small");

        String peterPost = peter.sharePost();
        String stevenPost = steven.sharePost();
        String alexPost = alex.sharePost();

        System.out.println(peterPost + ", " + peter.getUserName());
        System.out.println(stevenPost + ", " + steven.getUserName());
        System.out.println(alexPost + ", " + alex.getUserName());

        Assert.assertEquals("Welcome to Facebook", peterPost);
        Assert.assertEquals("Welcome to Twitter", stevenPost);
        Assert.assertEquals("Welcome to Snapchat", alexPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        User peter = new Millenials("Peter Big");

        String peterPost = peter.sharePost();
        System.out.println("Old publisher: " + peterPost);

        peter.setSocialPublisher(new TwitterPublisher());
        String peterPostNewPublisher = peter.sharePost();
        System.out.println("New publisher: " + peterPostNewPublisher);

        Assert.assertEquals("Welcome to Twitter", peterPostNewPublisher);
    }
}
