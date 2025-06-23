package CS_320.Contact_Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddingContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        contactService.addContact(contact);
        Contact retrieved = contactService.getContact("ty0nfj");
        assertEquals(contact, retrieved);
    }

    @Test
    public void testAddingDuplicateContactThrows() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        Contact contact2 = new Contact("ty0nfj", "Karen", "Marsh", "5126675679", "223 Last Dr");
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact(contact.getContactId());
        Contact retrieved = contactService.getContact(contact.getContactId());
        assertNull(retrieved);
    }

    @Test
    public void testUpdateFirstName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        contactService.addContact(contact);
        contactService.updateFirstName(contact.getContactId(),"Greg");
        Contact retrieved = contactService.getContact(contact.getContactId());
        assertEquals("Greg", retrieved.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        contactService.addContact(contact);
        contactService.updateLastName(contact.getContactId(),"Doe");
        Contact retrieved = contactService.getContact(contact.getContactId());
        assertEquals("Doe", retrieved.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        contactService.addContact(contact);
        contactService.updatePhone(contact.getContactId(),"5126336857");
        Contact retrieved = contactService.getContact(contact.getContactId());
        assertEquals("5126336857", retrieved.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        contactService.addContact(contact);
        contactService.updateAddress(contact.getContactId(),"222 Street St");
        Contact retrieved = contactService.getContact(contact.getContactId());
        assertEquals("222 Street St", retrieved.getAddress());
    }

    @Test
    public void testDeleteNonexistentContactThrows() {
        ContactService contactService = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("not_real_id");
        });
    }

    @Test
    public void testUpdateNonexistentContactThrows() {
        ContactService contactService = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("not_real_id", "Josh");
        });
    }

    @Test
    public void testUpdateWithLongValueThrows() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("ty0nfj", "John", "Smith", "5126678909", "123 Main St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName(contact.getContactId(), "AReallyLongNameThatIsntReal");
        });
    }
}
