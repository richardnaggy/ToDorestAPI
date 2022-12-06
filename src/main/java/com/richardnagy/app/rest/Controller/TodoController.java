package com.richardnagy.app.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.richardnagy.app.rest.Model.Task;
import com.richardnagy.app.rest.Repository.TodoRepository;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String Holamundo(){
        return"Hola mundo"; 
    }
    
    @GetMapping("/tasks")
    public List <Task> getTasks(){
        return todoRepository.findAll();
    } 

    @PostMapping("/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return"Saved Task";
    }
    
    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = todoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        todoRepository.save(updatedTask);
        return "updated Task";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id){
    Task deletedTask = todoRepository.findById(id).get();
    todoRepository.delete(deletedTask);
    return "Deleted Task";
    }


}    
