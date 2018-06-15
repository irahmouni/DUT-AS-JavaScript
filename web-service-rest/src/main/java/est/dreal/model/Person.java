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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom", nullable = false)
    private String lastName;

    @Column(name = "prenom", nullable = false)
    private String firstName;

    @Column(name = "femme", nullable = false)
    private boolean woman;


    @Override
    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public boolean isWoman() {
        return woman;
    }

    public void setWoman(final boolean woman) {
        this.woman = woman;
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

        this.woman = personToCopy.isWoman();
    }
}
