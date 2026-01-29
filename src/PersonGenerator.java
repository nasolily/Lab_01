import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;


public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> folks = new ArrayList<>();

        /*
        ID (a String)
        b. FirstName
        c. LastName
        d. Title (a string like Mr., Mrs., Ms., Dr., etc.)
        e. YearOfBirth (an int)

        000001, Bilbo, Baggins, Esq., 1060
        000002, Frodo, Baggins, Esq., 1120
        000003, Samwise, Gamgee, Esq., 1125
        000004, Peregrin, Took, Esq., 1126
        000005, Meridoc, Brandybuck, Esq., 1126
        */

        String id;
        String firstName;
        String lastName;
        String title;
        int YOB;

        String rec;

        boolean done = false;

        do {
            id = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getInt(in, "Enter the year of birth");

            rec = id + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;

            folks.add(rec);

            done = SafeInput.getYNConfirm(in, "Are you done?");


        } while (!done);
        String fileName = SafeInput.getNonZeroLenString(in, "Enter output file name: ");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path filePath = Paths.get(workingDirectory.getPath(), "src", fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (String person : folks) {
                writer.write(person);
                writer.newLine();
            }
            System.out.println("File saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}