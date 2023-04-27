package ibf2022.paf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7

@Service
public class TodoService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Transactional(rollbackFor = Exception.class)
    public String upsertTask(String username, List<Task> taskList) {
        int inserted = 0;
        String user_id = null;
        Optional<User> opt = userRepository.findUserByUsername(username);
        if (opt.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setName(username);
            user_id = userRepository.insertUser(user);
            if (user_id.length() < 8) {
                throw new RuntimeException("unable to create user");
            }
            for (Task t : taskList) {
                t.setUser_id(user_id);
                inserted = taskRepository.insertTask(t);
                if (inserted == 0) {
                    throw new RuntimeException("unable to insert tasks");
                }
            }
            return user_id;
        }
        User user = opt.get();
        user_id = user.getUserId();
        for (Task t : taskList) {
            t.setUser_id(user_id);
            inserted = taskRepository.insertTask(t);
            if (inserted == 0) {
                throw new RuntimeException("unable to insert tasks");
            }
        }
        return user_id;
    }
}
