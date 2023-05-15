package Crud.Crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personne")
public
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenoms")
    private String prenoms;
    @Column(name="age")
    private int age;


    public Person() {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.age = age;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenoms;
    }

    public void setPrenom(String prenom) {
        this.prenoms = prenoms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
// getters and setters
}
