import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void constructorTest() {
        Product p = new Product("123456", "Laptop", "A high-end laptop", 1500.00);

        assertEquals("123456", p.getID());
        assertEquals("Laptop", p.getName());
        assertEquals("A high-end laptop", p.getDesc());
        assertEquals(1500.00, p.getCost());
    }
    @Test
    void setID() {
        Product p = new Product("123456", "Laptop", "A high-end laptop", 1500.00);
        p.setID("000001");
        assertEquals("000001", p.getID());
    }

    @Test
    void setName() {
        Product p = new Product("123456", "Laptop", "A high-end laptop", 1500.00);
        p.setName("Desktop");
        assertEquals("Desktop", p.getName());
    }

    @Test
    void setDesc() {
        Product p = new Product("123456", "Laptop", "A high-end laptop", 1500.00);
        p.setDesc("An office desktop computer");
        assertEquals("An office desktop computer", p.getDesc());
    }

    @Test
    void setCost() {
        Product p = new Product("123456", "Laptop", "A high-end laptop", 1500.00);
        p.setCost(1200.00);
        assertEquals(1200.00, p.getCost());
    }

    @Test
    void toCSVDataString() {
        Product p = new Product("123456", "Laptop", "A high-end laptop", 1500.00);
        assertEquals("123456,Laptop,A high-end laptop,1500.0", p.toCSVDataString());
    }
}