package dev.falser.railways_test_task.articles.controllers;
import dev.falser.railways_test_task.articles.repositories.ArticleRepository;
import dev.falser.railways_test_task.articles.models.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    public String list(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles";
    }

    @GetMapping("/new")
    public String create(Model model) {
        return "article-create";
    }

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable Integer id) {
        var article = articleRepository.findCustomerById(id);
        model.addAttribute("article", article);
        return "article";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Integer id) {
        var article = articleRepository.findCustomerById(id);
        model.addAttribute("article", article);
        return "article-edit";
    }
}