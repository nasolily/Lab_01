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
    //        000001, Bilbo, Baggins, Esq., 1060
    //        000002, Frodo, Baggins, Esq., 1120
    //        000003, Samwise, Gamgee, Esq., 1125
    //        000004, Peregrin, Took, Esq., 1126
    //        000005, Meridoc, Brandybuck, Esq., 1126

                // prompt user for the fields
                ID = sio.getNonZeroLenString("Enter the ID [6 digits]");
                fName = sio.getNonZeroLenString("Enter the first name");
                lName = sio.getNonZeroLenString("Enter the last name");
                title = sio.getNonZeroLenString("Enter the title");
                YOB = sio.getRangedInt("Enter the year for age calculation: ", 1000, 9999);



                // create a Person object with the fields, add to the array list
                perp = new Person(ID, fName, lName, title, YOB);

                perps.add(perp);

                //Prompt user for more entries
                done = SafeInput.getYNConfirm(in, "Are you done?");


        } while (!done);
        String fileName = sio.getNonZeroLenString("Enter output file name: ");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName);

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