package comspringbootmongodb.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Tasks")
public class Task {

    @Id
    private String taskId;
    private String description;
    private String priority; // p1 p2 p3
    private String assignee;
    private String storyPoint; // 3
}
