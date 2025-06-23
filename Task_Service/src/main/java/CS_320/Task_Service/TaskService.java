package CS_320.Task_Service;
import java.util.HashMap;

public class TaskService {
    private HashMap<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException ("Task ID not found.");
        }
        tasks.remove(taskId);
    }

    public void updateName(String taskId, String newName) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException ("Task ID not found.");
        }
        Task task = tasks.get(taskId);
        task.setName(newName);
    }

    public void updateDescription(String taskId, String newDescription) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException ("Task ID not found.");
        }
        Task task = tasks.get(taskId);
        task.setDescription(newDescription);
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
