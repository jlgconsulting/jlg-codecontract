package jlg.codecontract;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a formal code contract condition
 */
public class CodeContract {
    /**
     * Check if the provided contract is verified.
     *
     * @param expression the logical condition/argument to check for validity
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyThat(boolean expression) {
        if (!expression) {
            throw new CodeContractException();
        }
    }

    /**
     * Check if the provided contract is verified.
     *
     * @param expression the logical condition/argument to check for validity
     * @param message    the custom error message to be written in the runtime exception
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyThat(boolean expression, String message) {
        if (!expression) {
            throw new CodeContractException(message);
        }
    }

    /**
     * Check if the provided String is not null or empty
     *
     * @param value the string value to be checked
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyNotEmpty(String value) {
        if (value == null) {
            throw new CodeContractException("String must not be null.");
        }
        if (value.length() == 0) {
            throw new CodeContractException("String must not be empty.");
        }
    }

    /**
     * Check if the provided String is not null or empty
     *
     * @param value   the string value to be checked
     * @param message the custom error message to be written in the runtime exception
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyNotEmpty(String value, String message) {
        if (value == null || value.length() == 0) {
            throw new CodeContractException(message);
        }
    }

    /**
     * Check if the provided Collection is not empty
     *
     * @param collection the collection to be value to be checked
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyNotEmpty(Collection collection) {
        if(collection == null){
            throw new CodeContractException("Collection must contain elements. Collection must not be null.");
        }
        if (collection.size() == 0) {
            throw new CodeContractException("Collection must contain elements. Collection must not be empty.");
        }
    }

    /**
     * Check if the provided Collection is not empty
     *
     * @param collection the collection to be value to be checked
     * @param message    the custom error message to be written in the runtime exception
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyNotEmpty(Collection collection, String message) {
        if(collection == null){
            throw new CodeContractException(message);
        }
        if (collection.size() == 0) {
            throw new CodeContractException(message);
        }
    }

    /**
     * Check if provided Integer is between the given values
     *
     * @param minValue min value
     * @param maxValue max value
     * @param value    the provided Integer value
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyBetween(int value, int minValue, int maxValue) {
        if ((value < minValue) || (value > maxValue)) {
            throw new CodeContractException("The provided numeric value is not in range. Value " + value + "; Range " + minValue + " - " + maxValue + ".");
        }
    }

    /**
     * Check if provided Integer is between the given values
     *
     * @param minValue min value
     * @param maxValue max value
     * @param value    the provided Integer value
     * @param message  the custom error message to be written in the runtime exception
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyBetween(int value, int minValue, int maxValue, String message) {
        if ((value < minValue) || (value > maxValue)) {
            throw new CodeContractException(message);
        }
    }

    /**
     * Check if provided Double is between the given values
     *
     * @param minValue min value
     * @param maxValue max value
     * @param value    the provided Double value
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyBetween(double value, double minValue, double maxValue) {
        if ((value < minValue) || (value > maxValue)) {
            throw new CodeContractException("The provided numeric value is not in range. Value " + value + "; Range " + minValue + " - " + maxValue + ".");
        }
    }

    /**
     * Check if provided Double is between the given values
     *
     * @param minValue min value
     * @param maxValue max value
     * @param value    the provided Double value
     * @param message  the custom error message to be written in the runtime exception
     * @throws CodeContractException in case the expression is invalid
     */
    public static void verifyBetween(double value, double minValue, double maxValue, String message) {
        if ((value < minValue) || (value > maxValue)) {
            throw new CodeContractException(message);
        }
    }

    /**
     * Check if provided String value matches the given RegEx
     *
     * @param value the value to check
     * @param regex the regex to check against
     * @throws CodeContractException in case the conntract is violated
     */
    public static void verifyRegex(String value, String regex) {
        verifyThat(value != null, "Incorrect call to verifyRegex(). Method needs a non null string as value argument.");
        verifyThat(regex != null, "Incorrect call to verifyRegex(). Method needs a non null string as regex argument.");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            throw new CodeContractException("The provided value does not macth the provided regex. Value " + value + "; Regex " + regex + ".");
        }
    }

    /**
     * Check if provided String value matches the given RegEx
     *
     * @param value   the value to check
     * @param regex   the regex to check against
     * @param message the custom error message to be written in the runtime exception
     * @throws CodeContractException in case the conntract is violated
     */
    public static void verifyRegex(String value, String regex, String message) {
        verifyThat(value != null, "Incorrect call to verifyRegex(). Method needs a non null string as value argument.");
        verifyThat(regex != null, "Incorrect call to verifyRegex(). Method needs a non null string as regex argument.");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            throw new CodeContractException(message);
        }
    }
}
