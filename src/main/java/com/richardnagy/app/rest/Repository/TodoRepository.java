package com.richardnagy.app.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.richardnagy.app.rest.Model.Task;

public interface TodoRepository extends JpaRepository<Task, Long> {
    
}
