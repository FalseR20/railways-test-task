package dev.falser.railways_test_task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping("/articles/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Article add(@RequestPart String title, @RequestPart String text) {
        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        article.setLikesCount(0);
        articleRepository.save(article);
        return article;
    }

    @GetMapping("/articles")
    public Iterable<Article> getList() {
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article get(@PathVariable Integer id) {
        return articleRepository.findCustomerById(id);
    }

    @PutMapping("/articles/{id}")
    public Article update(@PathVariable Integer id, @RequestPart String title, @RequestPart String text) {
        var article = articleRepository.findCustomerById(id);
        article.setTitle(title);
        article.setText(text);
        articleRepository.save(article);
        return article;
    }

    @PatchMapping("/articles/{id}")
    public Article partialUpdate(@PathVariable Integer id, @RequestPart Optional<String> title, @RequestPart Optional<String> text) {
        var article = articleRepository.findCustomerById(id);
        title.ifPresent(article::setTitle);
        text.ifPresent(article::setText);
        articleRepository.save(article);
        return article;
    }

    @DeleteMapping("/articles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        articleRepository.deleteById(id);
    }
}
