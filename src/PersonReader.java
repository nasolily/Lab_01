import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PersonReader {
    public static void main(String[] args) {

        File workingDirectory = new File(System.getProperty("user.dir"), "src");
        JFileChooser fileChooser = new JFileChooser(workingDirectory);


        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        int result = fileChooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected. Exiting program.");
            return;
        }

        Path file = fileChooser.getSelectedFile().toPath();

        try {
            List<String> lines = Files.readAllLines(file);

            System.out.printf("%-8s %-12s %-12s %-8s %-6s%n",
                    "ID", "FirstName", "LastName", "Title", "YOB");
            System.out.println("========================================================");

            for (String line : lines) {

                String[] field = line.split("\\s*,\\s*");

                String id = field[0];
                String first = field[1];
                String last = field[2];
                String title = field[3];
                String yob = field[4];

                System.out.printf("%-8s %-12s %-12s %-8s %-6s%n",
                        id, first, last, title, yob);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}