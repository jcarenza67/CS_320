package CS_320.Contact_Service;
import java.util.HashMap;

/** 
 * The ContactService class manages Contact objects in memory.
 * It supports adding, deleting, and updating contacts using a HashMap.
 */

public class ContactService {
    // Stores contacts, using contactId as the unique key
    private HashMap<String, Contact> contacts;

    // Constructor initializes the HashMap
    public ContactService() {
        contacts = new HashMap<>();
    }

    /**
     * Adds a new contact to the service if the contactId is unique.
     * @param contact The Contact object to add
     * @throws IllegalArgumentException if the contactId already exists
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException ("Contact ID must be unique.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact from the service by contactId.
     * @param contactId The unique ID of the contact to delete
     * @throws IllegalArgumentException if the contactId does not exist
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException ("Contact ID not found.");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact by contactId.
     * @param contactId The unique ID of the contact
     * @param newFirstName The new first name value
     * @throws IllegalArgumentException if the contactId does not exist
     */
    public void updateFirstName(String contactId, String newFirstName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException ("Contact ID not found.");
        }
        Contact contact = contacts.get(contactId);
        contact.setFirstName(newFirstName);
    }

    /**
     * Updates the last name of a contact by contactId.
     * @param contactId The unique ID of the contact
     * @param newLastName The new last name value
     * @throws IllegalArgumentException if the contactId does not exist
     */
    public void updateLastName(String contactId, String newLastName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException ("Contact ID not found.");
        }
        Contact contact = contacts.get(contactId);
        contact.setLastName(newLastName);
    }

    /**
     * Updates the phone number of a contact by contactId.
     * @param contactId The unique ID of the contact
     * @param newPhone The new phone value (must be exactly 10 digits)
     * @throws IllegalArgumentException if the contactId does not exist
     */
    public void updatePhone(String contactId, String newPhone) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException ("Contact ID not found.");
        }
        Contact contact = contacts.get(contactId);
        contact.setPhone(newPhone);
    }

    /**
     * Updates the address of a contact by contactId.
     * @param contactId The unique ID of the contact
     * @param newAddress The new address value
     * @throws IllegalArgumentException if the contactId does not exist
     */
    public void updateAddress(String contactId, String newAddress) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException ("Contact ID not found.");
        }
        Contact contact = contacts.get(contactId);
        contact.setAddress(newAddress);
    }

    /**
     * Gets a contact by contactId. Used for testing or inspection.
     * @param contactId The unique ID of the contact
     * @return The Contact object, or null if not found
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
