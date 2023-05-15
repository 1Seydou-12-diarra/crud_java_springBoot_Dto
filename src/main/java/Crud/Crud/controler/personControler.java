package Crud.Crud.controler;

import Crud.Crud.model.Person;
import Crud.Crud.model.dtoPersonne;
import Crud.Crud.service.personneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
class PersonController {
    @Autowired
    private personneService personService;

    // Récupère toutes les personnes
    @GetMapping("/getAll")
    public List<dtoPersonne> getAllPersons() {
        return personService.getAllPersons();
    }

    // Crée une personne
    @PostMapping("/create")
    public dtoPersonne createPerson(@RequestBody dtoPersonne personDTO) {
        // Convertit le DTO en modèle Person
        Person person = new Person();
        person.setNom(personDTO.getNom());
        person.setPrenom(personDTO.getPrenom());
        person.setAge(personDTO.getAge());

        // Sauvegarde la personne et obtient le modèle enregistré
        Person savedPerson = personService.save(person);

        // Convertit le modèle enregistré en DTO
        dtoPersonne savedPersonDTO = new dtoPersonne();
        savedPersonDTO.setId(savedPerson.getId());
        savedPersonDTO.setNom(savedPerson.getNom());
        savedPersonDTO.setPrenom(savedPerson.getPrenom());
        savedPersonDTO.setAge(savedPerson.getAge());

        return savedPersonDTO;
    }

    // Récupère une personne par son ID
    @GetMapping("/{id}")
    public dtoPersonne getPersonById(@PathVariable Long id) {
        // Récupère la personne par son ID
        Person person = personService.findById(id);

        // Convertit la personne en DTO
        dtoPersonne personDTO = new dtoPersonne();
        personDTO.setId(person.getId());
        personDTO.setNom(person.getNom());
        personDTO.setPrenom(person.getPrenom());
        personDTO.setAge(person.getAge());

        return personDTO;
    }

    // Met à jour une personne
    @PutMapping("/update/{id}")
    public dtoPersonne updatePerson(@PathVariable Long id, @RequestBody dtoPersonne personDTO) {
        // Récupère la personne par son ID
        Person person = personService.findById(id);

        // Met à jour les champs de la personne avec les valeurs du DTO
        person.setNom(personDTO.getNom());
        person.setPrenom(personDTO.getPrenom());
        person.setAge(personDTO.getAge());

        // Sauvegarde la personne mise à jour et obtient le modèle enregistré
        Person updatedPerson = personService.save(person);

        // Convertit le modèle enregistré en DTO
        dtoPersonne updatedPersonDTO = new dtoPersonne();
        updatedPersonDTO.setId(updatedPerson.getId());
        updatedPersonDTO.setNom(updatedPerson.getNom());
        updatedPersonDTO.setPrenom(updatedPerson.getPrenom());
        updatedPersonDTO.setAge(updatedPerson.getAge());

        return updatedPersonDTO;
    }

    // Supprime une personne par son ID
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
    }
}
