package comspringbootmongodb.service;

import comspringbootmongodb.modal.Task;
import comspringbootmongodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Curd

    public Task saveTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    public Task getTask(String tashId) {
        return taskRepository.findById(tashId).get();
    }

    public Task updateTask(Task task ,String taskId){
        Task task1 =  taskRepository.findById(taskId).get();
        task1.setAssignee(task.getAssignee());
        task1.setDescription(task.getDescription());
        task1.setPriority(task.getPriority());
        task1.setStoryPoint(task.getStoryPoint());

        return taskRepository.save(task1);

    }
    public String deleteTask(String taskId){
        taskRepository.deleteById(taskId);
        return "deleted with id = "+taskId;
    }

    public List<Task> getTaskByAssignedAndPriority(String assignee ,String Priority){

//        return taskRepository.findByAssigneeAndPriority(assignee,Priority);
        return taskRepository.fidTaskAssigneeAndPriority(assignee,Priority);
    }



}
