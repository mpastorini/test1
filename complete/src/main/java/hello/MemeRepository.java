package hello;

import org.springframework.data.repository.CrudRepository;

public interface MemeRepository extends CrudRepository<Meme, Long> {
}