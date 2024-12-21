package exam.services;

import exam.data.entities.Commande;
import exam.data.entities.Article;
import exam.data.repository.CommandeRepository;
import jakarta.persistence.EntityManager;

public class CommandeService {
    private CommandeRepository commandeRepository;

    public CommandeService(EntityManager em) {
        this.commandeRepository = new CommandeRepository(em);
    }

    public void save(Commande commande) {
        commandeRepository.save(commande);
    }

    public void addArticleToCommande(Long commandeId, Article article, int quantity) {
        commandeRepository.addArticleToCommande(commandeId, article, quantity);
    }

    public void removeArticleFromCommande(Long commandeId, Long articleId) {
     

    }

    public Commande findCommandeById(Long id) {
        return commandeRepository.findById(id);
    }
}
