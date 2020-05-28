package com.kodilla.hibernate.manytomany.facade;

public class FindingProcessException extends Exception {
    public static String CANNOT_FIND_COMPANY = "Cannot find any company containing the letters.";
    public static String CANNOT_FIND_EMPLOYEE = "Cannot find any employee containing the letters.";

    public FindingProcessException(String message) {
        super(message);
    }
}
