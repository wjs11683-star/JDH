package dohoon.jun.Exam.repository;

import dohoon.jun.Exam.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
