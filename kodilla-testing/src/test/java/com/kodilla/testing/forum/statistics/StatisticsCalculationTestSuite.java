package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculationTestSuite {

    private static int testNumber = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Test Suite started");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Test Suite ended");
    }

    @Before
    public void beforeEveryTest() {
        testNumber++;
        System.out.println("Executing test no. " + testNumber);
    }

    @Test
    public void testPostsNumberEqualsZero() {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            usersList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);

        StatisticsCalculation statistics = new StatisticsCalculation();
        statistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, statistics.getPostsPerUser(), 0.01);
        Assert.assertEquals(1, statistics.getCommentsPerUser(), 0.01);
        Assert.assertEquals(0, statistics.getCommentsPerPost(), 0.01);
    }

    @Test
    public void testPostsNumberEqualsThousand() {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            usersList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        StatisticsCalculation statistics = new StatisticsCalculation();
        statistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(100, statistics.getPostsPerUser(), 0.01);
        Assert.assertEquals(1, statistics.getCommentsPerUser(), 0.01);
        Assert.assertEquals(0.01, statistics.getCommentsPerPost(), 0.01);
    }

    @Test
    public void testCommentsNumberEqualsZero() {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            usersList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticsCalculation statistics = new StatisticsCalculation();
        statistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1, statistics.getPostsPerUser(), 0.01);
        Assert.assertEquals(0, statistics.getCommentsPerUser(), 0.01);
        Assert.assertEquals(0, statistics.getCommentsPerPost(), 0.01);
    }

    @Test
    public void testMorePostsThanComments() {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            usersList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        StatisticsCalculation statistics = new StatisticsCalculation();
        statistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(100, statistics.getPostsPerUser(), 0.01);
        Assert.assertEquals(1, statistics.getCommentsPerUser(), 0.01);
        Assert.assertEquals(0.01, statistics.getCommentsPerPost(), 0.01);
    }

    @Test
    public void testMoreCommentsThanPosts() {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            usersList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        StatisticsCalculation statistics = new StatisticsCalculation();
        statistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1, statistics.getPostsPerUser(), 0.01);
        Assert.assertEquals(100, statistics.getCommentsPerUser(), 0.01);
        Assert.assertEquals(100, statistics.getCommentsPerPost(), 0.01);
    }

    @Test
    public void testUsersNumberEqualsZero() {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        StatisticsCalculation statistics = new StatisticsCalculation();
        statistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, statistics.getPostsPerUser(), 0.01);
        Assert.assertEquals(0, statistics.getCommentsPerUser(), 0.01);
        Assert.assertEquals(0.01, statistics.getCommentsPerPost(), 0.01);
    }

    @Test
    public void testUsersNumberEqualsHundred() {
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for (int i=0; i<100; i++) {
            usersList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        StatisticsCalculation statistics = new StatisticsCalculation();
        statistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(10, statistics.getPostsPerUser(), 0.01);
        Assert.assertEquals(0.1, statistics.getCommentsPerUser(), 0.01);
        Assert.assertEquals(0.01, statistics.getCommentsPerPost(), 0.01);
    }
}
