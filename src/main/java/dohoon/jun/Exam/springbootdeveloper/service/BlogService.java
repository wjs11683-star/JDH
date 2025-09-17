package dohoon.jun.Exam.springbootdeveloper.service;


import dohoon.jun.Exam.repository.BlogRepository;
import dohoon.jun.Exam.springbootdeveloper.DTO.AddArticleRequest;
import dohoon.jun.Exam.springbootdeveloper.DTO.UpdateArticleRequest;
import dohoon.jun.Exam.springbootdeveloper.domain.Article;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드;
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());

    }
    //findall를 호출하여 article 테이블 모두 조회
    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    //ID 엔터티를 조회하고 없으면 IllegalArgumentException 예외처리 발생
    public Article findByID(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
    public void delete(long id){
        blogRepository.deleteById(id);
    }
    @Transactional // 트랜잭션 메서드
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found" + id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
