package comspringbootmongodb.controller;

import comspringbootmongodb.modal.Task;
import comspringbootmongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.saveTask(task);
    }

    @GetMapping
    public List<Task> findAllTasks() {
        return service.getTasks();
    }

    @GetMapping("/{taskId}")
    public Task findTask(@PathVariable String taskId) {
        return service.getTask(taskId);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@RequestBody Task task, @PathVariable String taskId) {
        return service.updateTask(task, taskId);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        return service.deleteTask(taskId);
    }

    @GetMapping("/assignee/{assignee}/priority/{priority}")
    public List<Task> getTaskByAssignedAndPriority(@PathVariable String assignee, @PathVariable String priority) {

        return service.getTaskByAssignedAndPriority(assignee, priority);
    }

}
