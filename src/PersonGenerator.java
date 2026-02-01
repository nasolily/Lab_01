import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {



        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";
        int YOB = 0;
        String csvRec = "";
        boolean done = false;

        Scanner in = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(in);

        ArrayList<Person> perps = new ArrayList<>();
        Person perp;

        do {
//            id = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
//            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
//            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
//            title = SafeInput.getNonZeroLenString(in, "Enter the title");
//            YOB = SafeInput.getInt(in, "Enter the year of birth");

                ID = sio.getNonZeroLengthString("Enter the ID [6 digits]");
                fName = sio.getNonZeroLengthString("Enter the first name");
                lName = sio.getNonZeroLengthString("Enter the last name");
                title = sio.getNonZeroLengthString("Enter the title");
                YOB = sio.getRangedInt("Enter the year for age calculation: ", 1000, 9999);



                // create a Person object with the fields, add to the array list
                perp = new Person(ID, fName, lName, title, YOB);

                perps.add(perp);

                //Prompt user for more entries
                done = SafeInput.getYNConfirm(in, "Are you done?");


        } while (!done);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (Person p : perps) {
                csvRec = p.toCSVDataString();
                writer.write(csvRec, 0, csvRec.length());
                writer.newLine();
            }

            writer.close();
            System.out.println("Data file written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}