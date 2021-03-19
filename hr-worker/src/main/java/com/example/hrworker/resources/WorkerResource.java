package com.example.hrworker.resources;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = repository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        var optionalWorker = repository.findById(id);
        return optionalWorker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
