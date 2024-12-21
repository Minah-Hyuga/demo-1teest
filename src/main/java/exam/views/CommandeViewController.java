package exam.views;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.scene.control.*;

import java.util.ArrayList;

import exam.data.entities.Article;
import exam.data.entities.Client;
import exam.data.entities.Commande;
import exam.services.ArticleService;
import exam.services.ClientService;
import exam.services.CommandeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class CommandeViewController {

    @FXML
    private TextField telephoneField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField adresseField;
    @FXML
    private ComboBox<Article> articleComboBox;
    @FXML
    private TextField prixField;
    @FXML
    private TextField quantiteField;
    @FXML
    private TableView<Article> articlesTable;
    @FXML
    private Label totalLabel;

    private ClientService clientService;
    private ArticleService articleService;
    private CommandeService commandeService;
    private Client clientActuel;
    private ObservableList<Article> articlesCommande = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Initialisation des services
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        EntityManager em = emf.createEntityManager();
        clientService = new ClientService(em);
        articleService = new ArticleService(em);
        commandeService = new CommandeService(em);

        // Configuration de la table
        articlesTable.setItems(articlesCommande);

        // Chargement des articles disponibles
        articleComboBox.setItems(FXCollections.observableArrayList(articleService.findAll()));
    }

    @FXML
    private void rechercherClient() {
        String telephone = telephoneField.getText();
        clientActuel = clientService.findClientByTelephone(telephone);

        if (clientActuel != null) {
            nomField.setText(clientActuel.getNomComplet());
            adresseField.setText(clientActuel.getAdresse());
        } else {
            // Afficher message d'erreur
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Client non trouvé");
            alert.setContentText("Aucun client trouvé avec ce numéro de téléphone.");
            alert.showAndWait();
        }
    }

    @FXML
    private void ajouterArticle() {
        Article articleSelectionne = articleComboBox.getValue();
        double prix = Double.parseDouble(prixField.getText());
        int quantite = Integer.parseInt(quantiteField.getText());

        // Vérification de la disponibilité
        if (articleSelectionne != null && quantite <= articleSelectionne.getQuantiteDisponible()) {
            Article articleCommande = new Article();
            articleCommande.setNom(articleSelectionne.getNom());
            articleCommande.setPrix(prix);
            articleCommande.setQuantite(quantite);

            articlesCommande.add(articleCommande);
            updateTotal();
        }
    }

    private void updateTotal() {
        double total = articlesCommande.stream()
                .mapToDouble(a -> a.getPrix() * a.getQuantite())
                .sum();
        totalLabel.setText(String.format("%.2f", total));
    }

    @FXML
    private void validerCommande() {
        if (clientActuel != null && !articlesCommande.isEmpty()) {
            Commande commande = new Commande();
            commande.setClient(clientActuel);
            commande.setArticles(new ArrayList<>(articlesCommande));

            commandeService.save(commande);

            // Réinitialiser le formulaire
            clearForm();
        }
    }

    private void clearForm() {
        telephoneField.clear();
        nomField.clear();
        adresseField.clear();
        articleComboBox.setValue(null);
        prixField.clear();
        quantiteField.clear();
        articlesCommande.clear();
        totalLabel.setText("0.0");
        clientActuel = null;
    }
}