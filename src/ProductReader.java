import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.List;
public class ProductReader {

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

                System.out.printf("%-8s %-15s %-25s %10s%n", "ID", "name", "desc", "cost");
                System.out.println("==============================================================");

                for (String line : lines) {

                    String[] field = line.split("\\s*,\\s*");

                    String ID = field[0];
                    String name = field[1];
                    String desc = field[2];
                    String cost = field[3];

                    double costValue = Double.parseDouble(cost);
                    System.out.printf("%-8s %-15s %-25s %10.2f%n", ID, name, desc, costValue);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }

