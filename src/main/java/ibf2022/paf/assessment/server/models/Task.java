package ibf2022.paf.assessment.server.models;

import java.time.LocalDate;

// TODO: Task 4

public class Task {

    private String username;
    private String description;
    private Integer priority;
    private LocalDate dueDate;
    private String user_id;
        
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Task [username=" + username + ", description=" + description + ", priority=" + priority + ", dueDate="
                + dueDate + ", user_id=" + user_id + "]";
    }
    
}
