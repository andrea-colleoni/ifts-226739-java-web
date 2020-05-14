package ifts.webdeveloper.springbootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PutMapping("/libri/{isbn}")
	public boolean saveLibro(@PathVariable("isbn") String isbn, @RequestBody Libro libroDaSalvare) {
		Libro libro = repository.findById(isbn).orElse(null);
		if (libro != null) {
			libro.setAnnoPubblicazione(libroDaSalvare.getAnnoPubblicazione());
			libro.setDescrizione(libroDaSalvare.getDescrizione());
			libro.setNumeroPagine(libroDaSalvare.getNumeroPagine());
			libro.setTitolo(libroDaSalvare.getTitolo());
			repository.save(libro);
			return true;
		}
		
		return false;
	}
}
