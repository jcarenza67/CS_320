package CS_320.Appointment_Service;
import java.util.Date;

// Joseph Wilfong

public class Appointment {
    
    private final String appointmentId;

    private Date appointmentDate;

    private String description;

    public Appointment (String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException ("ID cannot be null or longer than 10 characters.");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException ("Description cannot be null or longer than 50 characters");
        }

        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException ("Appointment date cannot be null or in the past.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }
    
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getDescription() {
        return description;
    }

    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException ("Appointment Date cannot be null or in the past.");
        }
        this.appointmentDate = new Date(appointmentDate.getTime());
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException ("Description cannot be longer than 50 characters.");
        }
        this.description = description;
    }
}

