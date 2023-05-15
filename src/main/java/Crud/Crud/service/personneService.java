package Crud.Crud.service;

import Crud.Crud.model.Person;
import Crud.Crud.model.dtoPersonne;
import Crud.Crud.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class personneService {
    // On injecte le repository de Personne
    @Autowired
    private PersonneRepository personRepository;
    // On déclare une instance de dtoPersonne (pas nécessaire)
    private dtoPersonne Person;
    // On déclare une instance de dtoPersonne (pas nécessaire)
    private Crud.Crud.model.dtoPersonne dtoPersonne;

    // On récupère toutes les Personnes et on les convertit en dtos
    public List<dtoPersonne> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        List<dtoPersonne> personDTOs = new ArrayList<>();
        for (Person person : persons) {
            personDTOs.add(convertToDTO(person));
        }
        return personDTOs;
    }

    // On convertit une Person en dtoPersonne (pas implémenté)
    private dtoPersonne convertToDTO(Person person) {
        return dtoPersonne;
    }

    // On sauvegarde une Person
    public Person save(Person person) {
        return personRepository.save(person);
    }

    // On cherche une Person par son id
    public Person findById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            // On lève une exception si la Person n'existe pas
            throw new RuntimeException("Person not found");
        }
    }

    // On supprime une Person par son id
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
