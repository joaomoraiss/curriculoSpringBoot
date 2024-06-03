package com.example.curriculo.controller;

import com.example.curriculo.model.Curriculum;
import com.example.curriculo.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculums")
public class CurriculumController {

    @Autowired
    private CurriculumRepository repository;

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Curriculum> create(@RequestBody Curriculum curriculum) {
        return ResponseEntity.ok(repository.save(curriculum));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> update(@PathVariable Long id, @RequestBody Curriculum curriculum) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        curriculum.setId(id);
        return ResponseEntity.ok(repository.save(curriculum));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
