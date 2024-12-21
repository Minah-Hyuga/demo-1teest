package exam.data.repository;

import java.util.List;

import exam.data.entities.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ArticleRepository {
    private EntityManager em;

    public ArticleRepository(EntityManager em) {
        this.em = em;
    }

    public List<Article> findAll() {
        TypedQuery<Article> query = em.createQuery(
                "SELECT a FROM Article a",
                Article.class);
        return query.getResultList();
    }

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }

    public void save(Article article) {
        em.getTransaction().begin();
        if (article.getId() == null) {
            em.persist(article);
        } else {
            em.merge(article);
        }
        em.getTransaction().commit();
    }

    public void updateQuantite(Long articleId, int nouvelleQuantite) {
        em.getTransaction().begin();
        Article article = em.find(Article.class, articleId);
        if (article != null) {
            article.setQuantiteDisponible(nouvelleQuantite);
        }
        em.getTransaction().commit();
    }

    public void deleteArticle(Long id) {
        em.getTransaction().begin();
        Article article = em.find(Article.class, id);
        if (article != null) {
            em.remove(article);
        }
        em.getTransaction().commit();
    }
}
