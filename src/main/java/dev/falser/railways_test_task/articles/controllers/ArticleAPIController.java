package dev.falser.railways_test_task.articles.controllers;

import dev.falser.railways_test_task.articles.repositories.ArticleRepository;
import dev.falser.railways_test_task.articles.models.Article;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleAPIController {

    private final ArticleRepository articleRepository;

    public ArticleAPIController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Article add(@RequestPart String title, @RequestPart String text) {
        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        article.setLikesCount(0);
        articleRepository.save(article);
        return article;
    }

    @GetMapping("")
    public Iterable<Article> getList() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Article get(@PathVariable Integer id) {
        return articleRepository.findCustomerById(id);
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable Integer id, @RequestPart String title, @RequestPart String text) {
        var article = articleRepository.findCustomerById(id);
        article.setTitle(title);
        article.setText(text);
        articleRepository.save(article);
        return article;
    }

    @PatchMapping("/{id}")
    public Article partialUpdate(@PathVariable Integer id, @RequestPart Optional<String> title, @RequestPart Optional<String> text) {
        var article = articleRepository.findCustomerById(id);
        title.ifPresent(article::setTitle);
        text.ifPresent(article::setText);
        articleRepository.save(article);
        return article;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        articleRepository.deleteById(id);
    }

    @PostMapping("/{id}/like")
    public Article like(@PathVariable Integer id) {
        var article = articleRepository.findCustomerById(id);
        article.setLikesCount(article.getLikesCount() + 1);
        articleRepository.save(article);
        return article;
    }
}
