package exam.services;

import exam.data.entities.Article;
import exam.data.repository.ArticleRepository;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(EntityManager em) {
        this.articleRepository = new ArticleRepository(em);
    }

    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public Article findArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteArticle(id); // Ensure this method accepts Long
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
