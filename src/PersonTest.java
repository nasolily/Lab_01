import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void constructorTest() {
        Person p = new Person("123456", "John", "Doe", "Mr.", 2000);

        assertEquals("123456", p.getIDNum());
        assertEquals("John", p.getFirstName());
        assertEquals("Doe", p.getLastName());
        assertEquals("Mr.", p.getTitle());
        assertEquals(2000, p.getYOB());
    }

    @Test
    void setIDNum() {
        Person p = new Person("123456", "John", "Doe", "Mr.", 2000);
        p.setIDNum("000001");
        assertEquals("000001", p.getIDNum());
    }

    @Test
    void setFirstName() {
        Person p = new Person("123456", "John", "Doe", "Mr.", 2000);
        p.setFirstName("Jane");
        assertEquals("Jane", p.getFirstName());
    }

    @Test
    void setLastName() {
        Person p = new Person("123456", "John", "Doe", "Mr.", 2000);
        p.setLastName("Smith");
        assertEquals("Smith", p.getLastName());
    }

    @Test
    void setTitle() {
        Person p = new Person("123456", "John", "Doe", "Mr.", 2000);
        p.setTitle("Dr.");
        assertEquals("Dr.", p.getTitle());
    }

    @Test
    void setYOB() {
        Person p = new Person("123456", "John", "Doe", "Mr.", 2000);
        p.setYOB(1995);
        assertEquals(1995, p.getYOB());
    }

    @Test
    void toCSVDataString() {
        Person p = new Person("123456", "John", "Doe", "Mr.", 2000);
        assertEquals("123456,John,Doe,Mr.,2000", p.toCSVDataString());
    }
}
