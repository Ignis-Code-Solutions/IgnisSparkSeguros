package com.generation.ignisspark.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ignisspark.model.Apolice;
import com.generation.ignisspark.repository.ApoliceRepository;
import com.generation.ignisspark.service.ApoliceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apolices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApoliceController {

	@Autowired
	private ApoliceRepository apoliceRepository;

	@Autowired
	private ApoliceService apoliceService;

	@GetMapping
	public ResponseEntity<List<Apolice>> getAll() {
		return ResponseEntity.ok(apoliceRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Apolice> getById(@PathVariable Long id) {
		return apoliceRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Apolice> post(@Valid @RequestBody Apolice apolice) {
		apolice.setValorSeguro(apoliceService.calcularValorFinal(apolice));
		return ResponseEntity.status(HttpStatus.CREATED).body(apoliceRepository.save(apolice));
	}

	@PutMapping
	public ResponseEntity<Apolice> put(@Valid @RequestBody Apolice apolice) {
		return apoliceRepository.findById(apolice.getId())
				.map(resposta -> {
					apolice.setValorSeguro(apoliceService.calcularValorFinal(apolice));
					return ResponseEntity.ok(apoliceRepository.save(apolice));
				})
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Apolice> apolice = apoliceRepository.findById(id);

		if (apolice.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		apoliceRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}