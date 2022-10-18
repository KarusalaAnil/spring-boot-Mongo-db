package comspringbootmongodb.repository;

import comspringbootmongodb.modal.Task;
import lombok.val;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {
    List<Task> findByAssigneeAndPriority(String assignee, String priority);

//    @Query("{assignee: ?0 ,priority: ?1}")
//    List<Task> fidTaskAssigneeAndPriority(String assignee, String priority);

    @Query(value = "{assignee: ?0 ,priority: ?1}" ,fields = "{'description': 1,storyPoint: 2}")
    List<Task> fidTaskAssigneeAndPriority(String assignee, String priority);

    List<Task> findByStoryPointIn(List<Integer> storyPoint);

    List<Task> findByStoryPointBetween(int minPrice, int maxPrice);

    List<Task> findByStoryPointGreaterThan(int price);

    List<Task> findByStoryPointLessThan(int price);

//    List<Task> findByAssignee(String assignee);//

//    @Query("{'assignee':{^K$: ?0}}")
//    @Query("{ assignee : { $regex : ?0 } }")


//    @Query("{assignee :?0}")
    @Query("{ assignee : { $regex : ?0 } }")
    List<Task> getAllAssigneedDetails(String assignee);

//    List<Task> findByNameIgnoreCaseContaining(String name);

    // operators
    // Pagination & Sorting
}
