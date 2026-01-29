import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();

        /* ID (a String as before in Person)
        b. Name (a String)
        c. Description (a String a short sentence)
        d. Cost (This is currency so it will be a Java double)

        000001, Pipeweed, Long Bottom Leaf, 600.0
        000002, Lembas, Elven Wayfare Bread, 200.0
        000003, Wine, Woodland Elf Wine, 400.0
        000004, Mushrooms, Farmer Took’s Finest, 125.0
        000005, Mithril, Enchanted Dwarven Armor, 3000.0*/

        String ID;
        String name;
        String desc;
        Double cost;

        String rec;

        boolean done = false;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the product ID [6 digits]");
            name = SafeInput.getNonZeroLenString(in, "Enter the product name");
            desc = SafeInput.getNonZeroLenString(in, "Enter the product description");
            cost = SafeInput.getDouble(in, "Enter the product cost");

            rec = ID + ", " + name + ", " + desc + ", " + cost;

            products.add(rec);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        } while (!done);
        String newFileName = SafeInput.getNonZeroLenString(in, "Enter the file name ");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path filePath = Paths.get(workingDirectory.getPath(), "src", newFileName);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
            System.out.println("File saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
