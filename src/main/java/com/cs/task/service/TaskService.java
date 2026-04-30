package com.cs.task.service;


import com.cs.task.model.Task;
import com.cs.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // Create Task
    public Task createTask(Task task) {
        return repository.save(task);
    }

    // Get All Tasks
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Update Task
    public Task updateTask(Long id, Task updatedTask) {
        Task task = repository.findById(id).orElseThrow();

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());

        return repository.save(task);
    }

    // Delete Task
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    // Mark Complete
    public Task markComplete(Long id) {
        Task task = repository.findById(id).orElseThrow();
        task.setCompleted(true);
        return repository.save(task);
    }
}