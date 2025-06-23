package CS_320.Task_Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TaskTest {
    Task task;

    @BeforeEach
    void setUp() {
        task = new Task("12345", "Do Homework", "Finish CS320 assignment");
    }

    @Test
    public void testGetTaskId() {
        assertEquals("12345",task.getTaskId());
    }

    @Test
    public void testGetTaskName() {
        assertEquals("Do Homework", task.getName());
    }

    @Test
    public void testGetTaskDescription() {
        assertEquals("Finish CS320 assignment", task.getDescription());
    }

    @Test
    public void testTaskNullIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Do Homework", "Finish CS320 assignment");
        });
    }

    @Test
    public void testTaskNullNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Finish CS320 assignment");
        });
    }

    @Test
    public void testTaskNullDescriptionThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Do Homework", null);
        });
    }

    @Test
    public void testSetNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("ThisIsAVeryLongNameThatIsLongerThan20Characters");
        });
    }

    @Test
    public void testSetDescriptionTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("ThisIsAVeryLongDescriptionThatIsLongerThan50characters");
        });
    }

    @Test
    public void testSetNameWorks() {
        task.setName("Do Chores");
        assertEquals("Do Chores", task.getName());
    }
    @Test
    public void testSetDescriptionWorks() {
        task.setDescription("Wash the dishes");
        assertEquals("Wash the dishes", task.getDescription());
    }
}
