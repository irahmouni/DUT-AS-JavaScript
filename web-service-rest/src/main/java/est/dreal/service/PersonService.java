package est.dreal.service;

import est.dreal.dao.PersonRepository;
import est.dreal.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by florian.iggiotti on 05/06/2018.
 */
@Service
public class PersonService implements IService<Person> {
    private final PersonRepository personRepository;

    /**
     * BeneficiaryService constructor.
     *
     * @param personRepository repository
     */
    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * @return list of persons
     */
    @Override
    public List<Person> findAll(){
        return personRepository.findAll(new Sort(Sort.Direction.ASC, "lastName"));
    }

    /**
     * @param id unique identifier
     * @return a person
     */
    @Override
    public Person findOne(final Long id){
        return personRepository.findOne(id);
    }

    /**
     * @param person, a person to save
     * @return the saved person
     */
    @Override
    public Person saveAndFlush(final Person person){
        return personRepository.saveAndFlush(person);
    }

    @Override
    public void delete(final Person person) {

    }
}
