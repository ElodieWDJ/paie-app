package dev.paie.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.repository.EmployeRepository;

@RestController
public class EmployeController {

	private EmployeRepository employeRepository;

	public EmployeController(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}

	@PostMapping(path = "employe")
	public ResponseEntity<?> creerEmploye(@RequestBody @Valid CreerEmployeRequestDto employe,
			BindingResult resultatValidation) {

		if (resultatValidation.hasErrors()) {
			return ResponseEntity.badRequest().body("Erreur");
		}

		return (ResponseEntity<?>) ResponseEntity.ok();

	}

}
