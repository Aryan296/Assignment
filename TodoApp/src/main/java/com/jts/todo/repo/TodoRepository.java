package com.jts.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jts.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
