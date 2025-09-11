package dohoon.jun.Exam.springbootdeveloper.service;


import dohoon.jun.Exam.repository.BlogRepository;
import dohoon.jun.Exam.springbootdeveloper.DTO.AddArticleRequest;
import dohoon.jun.Exam.springbootdeveloper.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final 이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드;
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());

    }
}
