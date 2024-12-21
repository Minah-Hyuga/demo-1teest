package exam.data.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Double prix;
    private Integer quantiteDisponible;

    @ManyToMany(mappedBy = "articles")
    private List<Commande> commandes;

    // Getters et Setters
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(Integer quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }

    // New methods for order quantity
    private Integer quantite; // Field for quantity in the order

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
}
