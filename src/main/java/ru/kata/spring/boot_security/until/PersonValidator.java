package ru.kata.spring.boot_security.until;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.models.Person;
import ru.kata.spring.boot_security.services.PeopleService;
import ru.kata.spring.boot_security.services.PersonDetailsService;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;


    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (peopleService.loadUserByUsername(person.getFirstName()).isPresent()) {
            errors.rejectValue("firstName", "", "a user with that name already exists");
        }
    }
}
