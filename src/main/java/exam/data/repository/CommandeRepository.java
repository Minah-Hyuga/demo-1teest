package exam.data.repository;

import exam.data.entities.Commande;
import exam.data.entities.Article;
import jakarta.persistence.EntityManager;

public class CommandeRepository {
    private EntityManager em;

    public CommandeRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Commande commande) {
        em.getTransaction().begin();
        if (commande.getId() == null) {
            em.persist(commande);
        } else {
            em.merge(commande);
        }
        em.getTransaction().commit();
    }

    public void addArticleToCommande(Long commandeId, Article article, int quantity) {
        em.getTransaction().begin();
        Commande commande = em.find(Commande.class, commandeId);
        if (commande != null) {
            commande.getArticles().add(article); // Assuming articles is a List<Article>
            // You may need to update the total price here
            em.merge(commande);
        }
        em.getTransaction().commit();
    }

    public void removeArticleFromCommande(Long commandeId, Long articleId) {
        em.getTransaction().begin();
        Commande commande = em.find(Commande.class, commandeId);
        if (commande != null) {
            commande.getArticles().removeIf(article -> article.getId().equals(articleId));
            // You may need to update the total price here
            em.merge(commande);
        }
        em.getTransaction().commit();
    }

    public Commande findById(Long id) {
        return em.find(Commande.class, id);
    }
}
