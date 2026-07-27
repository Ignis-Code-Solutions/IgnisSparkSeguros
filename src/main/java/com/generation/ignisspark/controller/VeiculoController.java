package com.generation.ignisspark.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ignisspark.model.Veiculo;
import com.generation.ignisspark.repository.VeiculoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll() {

        return ResponseEntity.ok(veiculoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getById(@PathVariable Long id) {

        return veiculoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> post(
            @Valid @RequestBody Veiculo veiculo) {

        return ResponseEntity.status(201)
                .body(veiculoRepository.save(veiculo));
    }

    @PutMapping
    public ResponseEntity<Veiculo> put(
            @Valid @RequestBody Veiculo veiculo) {

        if (veiculo.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Veiculo> veiculoExistente =
                veiculoRepository.findById(veiculo.getId());

        if (veiculoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                veiculoRepository.save(veiculo)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        Optional<Veiculo> veiculo =
                veiculoRepository.findById(id);

        if (veiculo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        veiculoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}