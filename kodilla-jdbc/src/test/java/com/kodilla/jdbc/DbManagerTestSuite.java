package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test //czy udało nam się połączyć z bazą danych
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance(); //wywołanie metody, która nawiązuje połączenie
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test //odczytanie wartości z tabeli USERS
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "select U.ID, U.FIRSTNAME, U.LASTNAME, count(*) as POSTS_NUMBER\n" +
                "from USERS U\n" +
                "join POSTS P on P.USER_ID = U.ID\n" +
                "group by P.USER_ID\n" +
                "having count(*)>=2";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int counter = 0;
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ". " +
                    resultSet.getString("FIRSTNAME") + " " +
                    resultSet.getString("LASTNAME"));
            counter++;
        }
        resultSet.close();
        statement.close();

        Assert.assertEquals(1, counter);
    }
}