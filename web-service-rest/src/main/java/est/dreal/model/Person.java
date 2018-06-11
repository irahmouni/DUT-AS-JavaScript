package est.dreal.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by florian.iggiotti on 05/06/2018.
 */
@Entity(name = "personne")
public class Person implements IEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String lastName;

    @Column(name = "prenom", nullable = false)
    private String firstName;


    @Override
    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param personToCopy Person
     */
    public void copy(final Person personToCopy) {
        if (personToCopy.getLastName() != null) {
            this.lastName = personToCopy.getLastName();
        }

        if (personToCopy.getFirstName() != null) {
            this.firstName = personToCopy.getFirstName();
        }
    }
}
