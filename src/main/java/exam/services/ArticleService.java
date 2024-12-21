package exam.services;

import exam.data.entities.Article;
import exam.data.repository.ArticleRepository;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
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
        articleRepository.deleteArticle(id);
    }
}
