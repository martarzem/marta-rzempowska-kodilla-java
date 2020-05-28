package com.kodilla.testing.forum.statistics;

public class StatisticsCalculation {

    private int usersNumber;
    private int postsNumber;
    private int commentsNumbers;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersNumber = statistics.usersNames().size();
        postsNumber = statistics.postsCount();
        commentsNumbers = statistics.commentsCount();
        if (usersNumber > 0) {
            postsPerUser = (double) postsNumber / usersNumber;
            commentsPerUser = (double) commentsNumbers / usersNumber;
        } else {
            postsPerUser = 0;
            commentsPerPost = 0;
        }
        if (postsNumber > 0) {
            commentsPerPost = (double) commentsNumbers / postsNumber;
        } else {
            commentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println(usersNumber);
        System.out.println(postsNumber);
        System.out.println(commentsNumbers);
        System.out.println(postsPerUser);
        System.out.println(commentsPerUser);
        System.out.println(commentsPerPost);
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }
}
