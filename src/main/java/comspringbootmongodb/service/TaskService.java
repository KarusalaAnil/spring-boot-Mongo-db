package comspringbootmongodb.service;

import comspringbootmongodb.modal.Task;
import comspringbootmongodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // Curd

    public Task saveTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }
    public List<Task> getTasks() {
        return repository.findAll();
    }
    public Task getTask(String tashId) {
        return repository.findById(tashId).get();
    }

    public Task updateTask(Task task ,String taskId){
        Task task1 =  repository.findById(taskId).get();
        task1.setAssignee(task.getAssignee());
        task1.setDescription(task.getDescription());
        task1.setPriority(task.getPriority());
        task1.setStoryPoint(task.getStoryPoint());

        return repository.save(task1);

    }
    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return "deleted with id = "+taskId;
    }

    public List<Task> getTaskByAssignedAndPriority(String assignee ,String Priority){

//        return repository.findByAssigneeAndPriority(assignee,Priority);
        return repository.fidTaskAssigneeAndPriority(assignee,Priority);
    }

    //Operators
    // IN
    public List<Task> getTaskByMultipleStoryPointValue(List<Integer> storypoint) {
        return repository.findByStoryPointIn(storypoint);
    }

    // between
    public List<Task> getTaskWithinStoryPointRange(int minPrice, int maxPrice) {
        return repository.findByStoryPointBetween(minPrice, maxPrice);
    }

    public List<Task> getTaskWithHigherPrice(int price) {
        return repository.findByStoryPointGreaterThan(price);
    }

    public List<Task> getTaskWithLessPrice(int price) {
        return repository.findByStoryPointLessThan(price);
    }

    public List<Task> getTaskWithLike(String assignee) {
        return repository.getAllAssigneedDetails(assignee);
    }

    public List<Task> getTaskWithSorting(String fieldName) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, fieldName));
    }

    public Page<Task> getTaskWithPageResponse(int offset, int limit) {
        return repository.findAll(PageRequest.of(offset, limit));
    }

    public Page<Task> getTaskWithSortingAndPagination(String fieldName, int offset, int limit) {
        return repository
                .findAll(
                        PageRequest.of(offset, limit)
                                .withSort(Sort.by(fieldName)
                                ));
    }
    //Operators


}
