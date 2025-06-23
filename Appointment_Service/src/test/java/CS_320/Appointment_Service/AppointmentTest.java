package CS_320.Appointment_Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentTest {
    private String validId;
    private Date futureDate;
    private String validDescription;

    @BeforeEach
    public void setup() {
        validId = "A12345";
        futureDate = new Date(System.currentTimeMillis() + 100000); // future date
        validDescription = "Valid description";
    }

    @Test
    public void testGetAppointmentId() {
        Appointment appointment = new Appointment(validId, futureDate, validDescription);
        assertEquals("A12345", appointment.getAppointmentId());
    }

    @Test
    public void testValidAppointmentCreation() {
        Appointment appointment = new Appointment(validId, futureDate, validDescription);
        assertEquals(validId, appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals(validDescription, appointment.getDescription());
    }

    @Test
    public void testNullAppointmentIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, validDescription);
        });
    }

    @Test
    public void testNullAppointmentDateThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", null, validDescription);
        });
    }

    @Test
    public void testPastAppointmentDateThrows() {
        String validId = "A12345";
        String validDescription = "Valid description";
        Date pastDate = new Date(System.currentTimeMillis() - 100000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(validId, pastDate, validDescription);
        });
    }

    @Test
    public void testSetValidAppointmentDate() {
        Appointment appointment = new Appointment(validId, futureDate, validDescription);
        Date newFutureDate = new Date(System.currentTimeMillis() + 200000);
        appointment.setAppointmentDate(newFutureDate);
        assertEquals(newFutureDate, appointment.getAppointmentDate());
    }

    @Test
    public void testNullAppointmentDescriptionThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(validId, futureDate, null);
        });
    }

    @Test
    public void testTooLongAppointmentDescriptionThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(validId, futureDate, "ThisDescriptionIsWayTooLongAndWillTriggerAnExceptionBecauseItsMoreThan50Characters");
        });
    }

    @Test
    public void testSetDescriptionWorks() {
        Appointment appointment = new Appointment(validId, futureDate, validDescription);
        appointment.setDescription("Doctors office Wednesday");
        assertEquals("Doctors office Wednesday", appointment.getDescription());
    }
}
