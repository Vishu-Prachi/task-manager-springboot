package com.cs.task.controller;

import com.cs.task.model.Task;
import com.cs.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Add Task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    // Get All Tasks
    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    // Edit Task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        service.deleteTask(id);
    }

    // Mark Complete
    @PutMapping("/{id}/complete")
    public Task markComplete(@PathVariable("id") Long id) {
        return service.markComplete(id);
    }
}