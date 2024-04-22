package dev.falser.railways_test_task.articles.repositories;

import dev.falser.railways_test_task.articles.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Article findCustomerById(Integer id);
}