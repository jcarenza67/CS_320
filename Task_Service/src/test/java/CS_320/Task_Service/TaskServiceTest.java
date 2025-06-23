package CS_320.Task_Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Laundry", "Do the laundry");
        service.addTask(task);
        assertEquals(task, service.getTask("1"));
    }

    @Test
    public void testAddDuplicateTaskThrows() {
        TaskService service = new TaskService();
        Task task1 = new Task("1", "Laundry", "Do the laundry");
        Task task2 = new Task("1", "Dishes", "Do the dishes");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Laundry", "Do the laundry");
        service.addTask(task);
        service.deleteTask("1");
        assertNull(service.getTask("1"));
    }

    @Test
    public void testDeleteNonexistentTaskThrows() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("404");
        });
    }

    @Test
    public void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Laundry", "Do the laundry");
        service.addTask(task);
        service.updateName("1", "Dishes");
        assertEquals("Dishes", service.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Laundry", "Do the laundry");
        service.addTask(task);
        service.updateDescription("1", "Do the dishes tonight");
        assertEquals("Do the dishes tonight", service.getTask("1").getDescription());
    }

    @Test
    public void testUpdateNameNonexistentTaskThrows() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("404", "Dishes");
        });
    }

    @Test
    public void testUpdateDescriptionNonexistentTaskThrows() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateDescription("404", "Whatever");
        });
    }

    @Test
    public void testUpdateNameTooLongThrows() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Laundry", "Do the laundry");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("1", "ThisNameIsWayTooLongForTheLimitSet");
        });
    }

    @Test
    public void testUpdateDescriptionTooLongThrows() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Laundry", "Do the laundry");
        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateDescription("1", "This description is intentionally way over fifty characters in length to test the limit.");
        });
    }
}
