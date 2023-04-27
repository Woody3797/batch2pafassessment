package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 6
@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer insertTask(Task task) {
        try {
            int rows = jdbcTemplate.update(DBQueries.INSERT_TASKS, task.getUser_id(), task.getDescription(), task.getPriority(), task.getDueDate());
            return rows;
        } catch (Exception e) {
            return 0;
        }
    }


}
