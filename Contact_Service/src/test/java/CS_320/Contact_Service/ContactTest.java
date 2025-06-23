package CS_320.Contact_Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ContactTest {
    Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
    }

    @Test
    public void testGetContactId() {
        assertEquals("ty0nfj",contact.getContactId());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("5126678909", contact.getPhone());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactNullFirstNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("id", null, "Smith", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactNullLastNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("id", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactNullContactIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactNullPhoneThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("id", "John", "Smith", null, "123 Main St");
        });
    }

    @Test
    public void testContactNullAddressThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("id", "John", "Smith", "1234567890", null);
        });
    }

    @Test
    public void testSetFirstNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisIsAVeryLongName");
        });
    }

    @Test
    public void testSetLastNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ThisIsAVeryLongName");
        });
    }

    @Test
    public void testSetAddressTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("ThisIsAVeryLongAddressThatWillNotWork");
        });
    }

    @Test
    public void testSetPhoneTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("87548976237846789465872436572609865924");
        });
    }

    @Test
    public void testSetFirstNameWorks() {
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetLastNameWorks() {
        contact.setLastName("Doe");
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testSetPhoneWorks() {
        contact.setPhone("5123335646");
        assertEquals("5123335646", contact.getPhone());
    }

    @Test
    public void testSetAddressWorks() {
        contact.setAddress("124 High Rd");
        assertEquals("124 High Rd", contact.getAddress());
    }
}

