package dev.falser.railways_test_task;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Article findCustomerById(Integer id);
}