package com.pluralsight;

public class NameFormatter {
    // Private constructor prevents objects from being created
    private NameFormatter() {

    }

    // Formats a name using only first name and last name
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // Formats a name using prefix, first name, middle name, last name, and suffix
    public static String format(String prefix, String firstName,
                                String middleName, String lastName, String suffix) {

        // Start with the required last name and comma
        String formattedName = lastName + ", ";

        // Add prefix if one was provided
        if (prefix != null && !prefix.isEmpty()) {
            formattedName += prefix + " ";
        }

        // First name is required
        formattedName += firstName;

        // Add middle name if one was provided
        if (middleName != null && !middleName.isEmpty()) {
            formattedName += " " + middleName;
        }

        // Add suffix if one was provided
        if (suffix != null && !suffix.isEmpty()) {
            formattedName += ", " + suffix;
        }

        return formattedName;
    }

    // Formats a full name provided as one String
    public static String format(String fullName) {

        // Separate the suffix from the rest of the name
        String[] nameParts = fullName.split(",");

        // Get the name before the comma
        String[] nameWords = nameParts[0].trim().split("\\s+");

        // Get the suffix if it exists
        String suffix = "";
        if (nameParts.length > 1) {
            suffix = nameParts[1].trim();
        }

        String prefix = "";
        String firstName;
        String middleName = "";
        String lastName;

        // Check whether the first word is a prefix
        int startIndex = 0;

        if (nameWords[0].equals("Mr.") ||
                nameWords[0].equals("Mrs.") ||
                nameWords[0].equals("Ms.") ||
                nameWords[0].equals("Dr.")) {

            prefix = nameWords[0];
            startIndex = 1;
        }

        // First name is the first name after the optional prefix
        firstName = nameWords[startIndex];

        // Last name is the final word
        lastName = nameWords[nameWords.length - 1];

        // Middle name is optional
        if (nameWords.length - startIndex > 2) {
            middleName = nameWords[startIndex + 1];
        }

        // Use the five-parameter format method
        return format(prefix, firstName, middleName, lastName, suffix);
    }
}
