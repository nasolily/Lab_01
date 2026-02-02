import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class ObjInputTest {

    @Test
    void testGetNonZeroLenString() {
        String simulatedInput = "Hello\n"; // user types "Hello"
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        String result = sio.getNonZeroLenString("Enter a string");
        assertEquals("Hello", result);
    }

    @Test
    void testGetRangedInt() {
        String simulatedInput = "50\n"; // user types 50
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        int result = sio.getRangedInt("Enter a number", 10, 100);
        assertEquals(50, result);
    }

    @Test
    void testGetInt() {
        String simulatedInput = "123\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        int result = sio.getInt("Enter any int");
        assertEquals(123, result);
    }

    @Test
    void testGetDouble() {
        String simulatedInput = "3.14\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        double result = sio.getDouble("Enter a double");
        assertEquals(3.14, result, 0.001);
    }

    @Test
    void testGetRangedDouble() {
        String simulatedInput = "25.5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        double result = sio.getRangedDouble("Enter a ranged double", 10, 50);
        assertEquals(25.5, result, 0.001);
    }

    @Test
    void testGetYNConfirmYes() {
        String simulatedInput = "Y\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        boolean result = sio.getYNConfirm("Are you done?");
        assertTrue(result); // expects true for "Y"
    }

    @Test
    void testGetYNConfirmNo() {
        String simulatedInput = "N\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        boolean result = sio.getYNConfirm("Are you done?");
        assertFalse(result); // expects false for "N"
    }

    @Test
    void testGetRegExString() {
        String simulatedInput = "abc123\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(sc);

        String result = sio.getRegExString("Enter ID", "[a-z]{3}\\d{3}");
        assertEquals("abc123", result);
    }
}
