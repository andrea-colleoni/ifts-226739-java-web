package ifts.webdeveloper.springbootrestapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ifts.webdeveloper.springbootrestapi.model.Autore;

@RepositoryRestResource(collectionResourceRel = "autori", path = "autori")
public interface AutoreRepository extends PagingAndSortingRepository<Autore, String> {

}
