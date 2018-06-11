package est.dreal.dao;

import est.dreal.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by florian.iggiotti on 05/06/2018.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
