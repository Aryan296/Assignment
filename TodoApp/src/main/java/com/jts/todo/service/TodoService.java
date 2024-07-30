package com.jts.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jts.todo.dto.TodoDto;
import com.jts.todo.entity.Todo;
import com.jts.todo.repo.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {

	private TodoRepository todoRepository;

	private ModelMapper modelMapper;

	public TodoDto addTodo(TodoDto todoDto) {
		Todo todo = modelMapper.map(todoDto, Todo.class);

		todo = todoRepository.save(todo);

		return modelMapper.map(todo, TodoDto.class);
	}
	
	public TodoDto getTodo(Long id) {
		Todo todo = todoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("TODO not found."));
		
		return modelMapper.map(todo, TodoDto.class);
	}
	
	public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }
	
	// complete TODO
	// Update TODO List

}
