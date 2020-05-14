package ifts.webdeveloper.springbootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifts.webdeveloper.springbootrestapi.model.Libro;
import ifts.webdeveloper.springbootrestapi.repository.LibroRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LibriController {

	@Autowired
	private LibroRepository repository;
	
	@GetMapping("/libri")
	public Iterable<Libro> getLibri() {
		return repository.findAll();
	}
}
