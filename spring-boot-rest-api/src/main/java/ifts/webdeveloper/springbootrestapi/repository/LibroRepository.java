package ifts.webdeveloper.springbootrestapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ifts.webdeveloper.springbootrestapi.model.Libro;

@RepositoryRestResource(collectionResourceRel = "libri", path = "libri")
public interface LibroRepository extends PagingAndSortingRepository<Libro, String> {

}
