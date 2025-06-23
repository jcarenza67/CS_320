package CS_320.Contact_Service;

/**
 * The Contact class represents a contact with a unique ID, first name, last name,
 * phone number, and address. Field values are validated upon creation and when updated.
 */
public class Contact {
    /** The unique identifier for the contact. Cannot be null, longer than 10 chars, or changed after creation. */
    private final String contactId;
    /** The first name of the contact. Cannot be null or longer than 10 chars. */
    private String firstName;
    /** The last name of the contact. Cannot be null or longer than 10 chars. */
    private String lastName;
    /** The phone number for the contact. Must be exactly 10 digits, and not null. */
    private String phone;
    /** The address for the contact. Cannot be null or longer than 30 chars. */
    private String address;

    /**
     * Constructs a new Contact object after validating all parameters.
     * @param contactId The unique identifier for the contact (max 10 chars, not null)
     * @param firstName The first name of the contact (max 10 chars, not null)
     * @param lastName The last name of the contact (max 10 chars, not null)
     * @param phone The phone number (exactly 10 digits, not null)
     * @param address The address (max 30 chars, not null)
     * @throws IllegalArgumentException if any validation fails
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
        throw new IllegalArgumentException("Contact ID cannot be null or longer than 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null or longer than 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null or longer than 10 characters.");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null or longer than 30 characters.");
        }
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Gets the contact's phone number.
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the contact's address.
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the unique contact ID.
     * @return the contact ID
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Gets the contact's first name.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the contact's last name.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the contact's address after validation.
     * @param address The new address (max 30 chars, not null)
     * @throws IllegalArgumentException if address is invalid
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null or longer than 30 characters.");
        }
        this.address = address;
    }

    /**
     * Updates the contact's first name after validation.
     * @param firstName The new first name (max 10 chars, not null)
     * @throws IllegalArgumentException if first name is invalid
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null or longer than 10 characters.");
        }
        this.firstName = firstName;
    }

    /**
     * Updates the contact's last name after validation.
     * @param lastName The new last name (max 10 chars, not null)
     * @throws IllegalArgumentException if last name is invalid
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null or longer than 10 characters.");
        }
        this.lastName = lastName;
    }

    /**
     * Updates the contact's phone number after validation.
     * @param phone The new phone number (must be exactly 10 digits, not null)
     * @throws IllegalArgumentException if phone number is invalid
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        this.phone = phone;
    }

}