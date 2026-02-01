import java.util.Scanner;

public class SafeInputObj {

    private Scanner pipe;

    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

    /**
     * Constructor that allows a Scanner to be injected
     * @param scanner Scanner to use for input
     */
    public SafeInputObj(Scanner scanner) {
        pipe = scanner;
    }

    /**
     * @param prompt Prompt displayed to the user
     * @return A non-empty String
     */
    public String getNonZeroLengthString(String prompt) {
        String retString;
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Gets an integer from the user
     * @param prompt Prompt displayed to the user
     * @return A valid integer
     */
    public int getInt(String prompt) {
        int retVal;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                return retVal;
            } else {
                pipe.nextLine(); // discard bad input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    /**
     * Gets an integer within a specified range
     * @param prompt Prompt displayed to the user
     * @param low Lower bound (inclusive)
     * @param high Upper bound (inclusive)
     * @return A valid ranged integer
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal;
        do {
            retVal = getInt(prompt + " [" + low + " - " + high + "]");
        } while (retVal < low || retVal > high);
        return retVal;
    }

    /**
     * Gets a double from the user
     * @param prompt Prompt displayed to the user
     * @return A valid double
     */
    public double getDouble(String prompt) {
        double retVal;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear buffer
                return retVal;
            } else {
                pipe.nextLine();
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Gets a double within a specified range
     * @param prompt Prompt displayed to the user
     * @param low Lower bound (inclusive)
     * @param high Upper bound (inclusive)
     * @return A valid ranged double
     */
    public double getRangedDouble(String prompt, double low, double high) {
        double retVal;
        do {
            retVal = getDouble(prompt + " [" + low + " - " + high + "]");
        } while (retVal < low || retVal > high);
        return retVal;
    }

    /**
     * Gets a yes or no confirmation from the user
     * @param prompt Prompt displayed to the user
     * @return true for yes, false for no
     */
    public boolean getYesNoConfirm(String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
        } while (!response.equals("Y") && !response.equals("N"));

        return response.equals("Y");
    }
}