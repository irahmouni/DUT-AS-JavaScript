package est.dreal.controller;

import est.dreal.model.Person;
import est.dreal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by florian.iggiotti on 05/06/2018.
 */
@RestController
@RequestMapping("/persons")
@CrossOrigin
public class PersonController {
    /**
     * Person service.
     */
    private final PersonService personService;

    /**
     * Constructor.
     *
     * @param personService service
     */
    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }


    /**
     * Gets all persons.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAll() {
        return personService.findAll();
    }

    /**
     * Gets a person by id.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Person getOne(@PathVariable Long id) {
        return personService.findOne(id);
    }

    /**
     * Creates a person.
     */
    @RequestMapping(method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return personService.saveAndFlush(person);
    }

    /**
     * Updates a person.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        Person personToUpdate = personService.findOne(id);
        personToUpdate.copy(person);

        return personService.saveAndFlush(personToUpdate);
    }

    /**
     * Deletes a person.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Person person = personService.findOne(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personService.delete(person);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
