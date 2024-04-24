package dev.falser.railways_test_task.articles.controllers;

import dev.falser.railways_test_task.articles.repositories.ArticleRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article-images")
public class ArticleImageController {
    private final ArticleRepository articleRepository;

    public ArticleImageController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/{id}")
    public ByteArrayResource getImage(@PathVariable Integer id) {
        var article = articleRepository.findCustomerById(id);
        return new ByteArrayResource(article.getImage());
    }
}
