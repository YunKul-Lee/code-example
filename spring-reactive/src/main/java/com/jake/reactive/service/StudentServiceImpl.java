package com.jake.reactive.service;

import com.jake.reactive.model.Student;
import com.jake.reactive.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    @Override
    public Flux<Student> saveAllStudents(Flux<Student> students) {
        return studentRepo.saveAll(students);
    }

    @Override
    public Mono<Student> updateStudent(Student student, Long id) {
        return studentRepo.findById(id)
                .flatMap(foundStudent -> {
                    foundStudent.setFirstname(student.getFirstname());
                    foundStudent.setLastname(student.getLastname());
                    foundStudent.setAge(student.getAge());

                    return studentRepo.save(foundStudent);
                });
    }

    @Override
    public Mono<Student> saveSingleStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Mono<Student> findStudentById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Flux<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public String deleteById(Long id) {
        studentRepo.deleteById(id);
        return "Student with ID: " + id + " deleted";
    }

    @Override
    public void deleteAll() {
        studentRepo.deleteAll();
    }
}
