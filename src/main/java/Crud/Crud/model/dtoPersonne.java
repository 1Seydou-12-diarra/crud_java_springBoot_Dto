package Crud.Crud.model;

public class dtoPersonne {
    // On déclare les champs de notre objet DTO
    private Long id;
    private String prenoms;
    private String nom;
    private Integer age;

    public dtoPersonne() {
        // Constructeur par défaut
    }

    // Constructeur qui initialise tous les champs
    public dtoPersonne(Long id, String prenoms, String nom, Integer age) {
        this.id = id;
        this.prenoms = prenoms;
        this.nom = nom;
        this.age = age;
    }

    // Getters et Setters pour tous les champs
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenoms;
    }

    public void setPrenom(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
