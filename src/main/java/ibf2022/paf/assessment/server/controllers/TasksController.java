package ibf2022.paf.assessment.server.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8

@Controller
@RequestMapping
public class TasksController {

    @Autowired
    TodoService service;


    @PostMapping(path = "/task")
    public ModelAndView saveTask(@RequestBody MultiValueMap<String, String> payload) {
        ModelAndView model = new ModelAndView("result.html");
        List<Task> taskList = new ArrayList<>();
        String username = payload.getFirst("username");
        System.out.println(payload);
        for (int i = 0; i < (payload.size()-1) / 3; i++) {
            Task task = new Task();
            task.setUsername(username);
            task.setDescription(payload.get("description-" + String.valueOf(i)).get(0));
            task.setPriority(Integer.parseInt(payload.get("priority-" + String.valueOf(i)).get(0)));
            task.setDueDate(LocalDate.parse(payload.get("dueDate-" + String.valueOf(i)).get(0)));
            taskList.add(task);
        }
        String user_id = service.upsertTask(username, taskList);

        if (user_id.length() < 8) {
            model.setViewName("error");
            model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return model;
        }
        model.setStatus(HttpStatus.OK);
        model.addObject("taskCount", taskList.size());
        model.addObject("username", username);
        return model;
    }
    // {username=[test], description-0=[qwe], priority-0=[1], dueDate-0=[2023-03-27], description-1=[asd], priority-1=[2], dueDate-1=[2023-04-11]}
    // [Task [username=test2, description=ewqrwq, priority=1, dueDate=2023-04-04, user_id=null]]
}
