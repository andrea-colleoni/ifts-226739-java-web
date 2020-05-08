package ifts.webdeveloper.springbootrestapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ifts.webdeveloper.springbootrestapi.model.Genere;

@RepositoryRestResource(collectionResourceRel = "generi", path = "generi")
public interface GenereRepository extends PagingAndSortingRepository<Genere, String> {

}
