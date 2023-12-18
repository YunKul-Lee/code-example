package com.jake.reactive.service;

import com.jake.reactive.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Flux<Student> saveAllStudents(Flux<Student> students);

    Mono<Student> updateStudent(Student student, Long id);

    Mono<Student> saveSingleStudent(Student student);

    Mono<Student> findStudentById(Long id);

    Flux<Student> findAllStudents();

    String deleteById(Long id);

    void deleteAll();
}
