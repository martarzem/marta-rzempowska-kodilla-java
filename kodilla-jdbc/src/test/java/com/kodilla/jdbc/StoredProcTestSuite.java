package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given - wypełnia kolumnę VIP_LEVEL wartością "Not set" dla wszystkich czytelników
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When - wywołujemy procedurę UpdateVipLevels()
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        //Then
        //pobierany info z bazy o ilości rekordów z "Not set"; jedyną prawidłową wartością będzie 0 (skoro przeprowadziliśmy procedurę)
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = \"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = NULL";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UPDATEBESTSELLERS('2020-06-07')";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS NULL_QTY FROM BOOKS WHERE BESTSELLER = NULL ";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int nullQty = -1;
        if(resultSet.next()) {
            nullQty = resultSet.getInt("NULL_QTY");
        }
        assertEquals(0, nullQty);


    }
}
