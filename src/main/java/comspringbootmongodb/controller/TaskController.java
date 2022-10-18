package comspringbootmongodb.controller;

import comspringbootmongodb.modal.Task;
import comspringbootmongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    //operator
    @PostMapping("/search")
    public List<Task> getTaskByMultipleStoryPointValue(@RequestBody List<Integer> point){
        return service.getTaskByMultipleStoryPointValue(point);
    }
    @GetMapping("/min/{minPrice}/max/{maxPrice}")
    public List<Task> getTaskWithinStoryPointRange(@PathVariable int minPrice,@PathVariable int maxPrice){
        return service.getTaskWithinStoryPointRange(minPrice, maxPrice);
    }

    @GetMapping("/high/{price}")
    public List<Task> getTaskWithHigherPrice(@PathVariable int price){
        return service.getTaskWithHigherPrice(price);
    }

    @GetMapping("/less/{price}")
    public List<Task> getTaskWithLessPrice(@PathVariable int price){
        return service.getTaskWithLessPrice(price);
    }
    //operator
    @GetMapping("/like/{assignee}")
    public List<Task> getTaskWithLike(@PathVariable String assignee){
        return service.getTaskWithLike(assignee);
    }

    //sorting
    @GetMapping("/sort/{fieldName}")
    public List<Task> getTaskWithSorting(@PathVariable String fieldName) {
        return service.getTaskWithSorting(fieldName);
    }

    //pagination
    @GetMapping("/page/{offset}/{limit}")
    public Page<Task> getTaskWithPageResponse(@PathVariable int offset, @PathVariable int limit) {
        return service.getTaskWithPageResponse(offset, limit);
    }

    //sorting & pagination
    @GetMapping("/pageWithSort/{fieldName}/{offset}/{limit}")
    public Page<Task> getTaskWithSortingAndPagination(@PathVariable String fieldName, @PathVariable int offset, @PathVariable int limit) {
        return service.getTaskWithSortingAndPagination(fieldName, offset, limit);
    }
}
