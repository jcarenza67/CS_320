package CS_320.Appointment_Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService service;
    private Appointment appointment1;
    private Appointment appointment2;

    @BeforeEach
    public void setup() {
        service = new AppointmentService();

        appointment1 = new Appointment(
            "ID123",
            new Date(System.currentTimeMillis() + 100000),
            "First appointment"
        );

        appointment2 = new Appointment(
            "ID456",
            new Date(System.currentTimeMillis() + 200000),
            "Second appointment"
        );
    }

    @Test
    public void testAddAppointmentSuccess() {
        service.addAppointment(appointment1);
        Appointment result = service.getAppointment("ID123");
        assertNotNull(result);
        assertEquals("First appointment", result.getDescription());
    }

    @Test
    public void testAddDuplicateAppointmentThrows() {
        service.addAppointment(appointment1);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment1);
        });
        assertEquals("Appointment ID already exists.", thrown.getMessage());
    }

    @Test
    public void testDeleteAppointmentSuccess() {
        service.addAppointment(appointment1);
        service.deleteAppointment("ID123");
        assertNull(service.getAppointment("ID123"));
    }

    @Test
    public void testDeleteNonExistingAppointmentThrows() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("NON_EXISTENT_ID");
        });
        assertEquals("Appointment ID not found.", thrown.getMessage());
    }

    @Test
    public void testGetAppointmentReturnsNullIfNotFound() {
        assertNull(service.getAppointment("NO_ID"));
    }

    @Test
    public void testAddSecondAppointmentSuccess() {
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);
        assertNotNull(service.getAppointment("ID123"));
        assertNotNull(service.getAppointment("ID456"));
    }
}
