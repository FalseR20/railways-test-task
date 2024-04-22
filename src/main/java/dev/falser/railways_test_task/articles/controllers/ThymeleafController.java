package dev.falser.railways_test_task.articles.controllers;
import dev.falser.railways_test_task.articles.repositories.ArticleRepository;
import dev.falser.railways_test_task.articles.models.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ThymeleafController {

    private final ArticleRepository articleRepository;

    public ThymeleafController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    public String showArticles(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles";
    }
}