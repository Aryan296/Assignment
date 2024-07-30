package com.jts.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jts.todo.dto.TodoDto;
import com.jts.todo.service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class ToDOController {

	private TodoService todoService;

	@PostMapping
	public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
		TodoDto savedTodo = todoService.addTodo(todoDto);

		return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<TodoDto>> getAllTodos() {
		return ResponseEntity.ok(todoService.getAllTodos());
	}
	
	@GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){
        return new ResponseEntity<>(todoService.getTodo(todoId), HttpStatus.OK);
    }
	
	// Update TODO
	// Delete
	

}
