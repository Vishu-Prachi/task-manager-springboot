package com.cs.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.task.model.Task;




public interface TaskRepository extends JpaRepository<Task, Long>{

}

