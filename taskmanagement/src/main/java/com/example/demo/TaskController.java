package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
    	LocalDateTime date=LocalDateTime.now();
    	 task.setDueDate(date);;
    	
        return taskService.createTask(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

   

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @GetMapping("/task/search")
    public List<Task> searchTasksByTitle(@RequestParam String title) {
        return taskService.searchTasksByTitle(title);
    }
}
