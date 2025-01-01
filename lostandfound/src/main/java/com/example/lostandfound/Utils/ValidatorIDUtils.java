package com.example.lostandfound.Utils;
import java.util.regex.Pattern;

public class ValidatorIDUtils {

    // validate the format of student IDs
    private static final String STUDENT_ID_REGEX = "^[A-Z]{2}[A-Z]{2}[A-Z]{2}\\d{2}\\d{3}$";

    /**
     * Validates the format of a student ID.
     * 
     * @param studentID The student ID to validate.
     * @return true if the format is valid, false otherwise.
     */
    public static boolean validateStudentIDFormat(String studentID) {
        if (studentID == null || studentID.isEmpty()) {
            System.out.println("Student ID cannot be null or empty.");
            return false;
        }

        boolean matches = Pattern.matches(STUDENT_ID_REGEX, studentID);
        if (!matches) {
            System.out.println("Student ID format is invalid: " + studentID);
        } else {
            System.out.println("Student ID format is valid: " + studentID);
        }
        return matches;
    }

    /**
     * Main method for testing the utility.
     */
    public static void main(String[] args) {
        // Test cases
        String studentID1 = "ITCSIU23032"; // Valid example
        String studentID2 = "INVALID123"; // Invalid example
        String studentID3 = ""; // Empty example
        String studentID4 = null; // Null example

        System.out.println("Is studentID1 valid? " + validateStudentIDFormat(studentID1));
        System.out.println("Is studentID2 valid? " + validateStudentIDFormat(studentID2));
        System.out.println("Is studentID3 valid? " + validateStudentIDFormat(studentID3));
        System.out.println("Is studentID4 valid? " + validateStudentIDFormat(studentID4));
    }
}
