package exam.services;

import exam.data.entities.Commande;
import exam.data.entities.Article;
import exam.data.repository.CommandeRepository;

public class CommandeService {
    private CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public void saveCommande(Commande commande) {
        commandeRepository.save(commande);
    }

    public void addArticleToCommande(Long commandeId, Article article, int quantity) {
        commandeRepository.addArticleToCommande(commandeId, article, quantity);
    }

    public void removeArticleFromCommande(Long commandeId, Long articleId) {
        commandeRepository.removeArticleFromCommande(commandeId, articleId);
    }

public Commande findCommandeById(Long id) {
        return commandeRepository.findById(id);
    }
}
