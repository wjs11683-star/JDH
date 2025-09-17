package dohoon.jun.Exam.springbootdeveloper.Controller;
import dohoon.jun.Exam.springbootdeveloper.DTO.AddArticleRequest;
import dohoon.jun.Exam.springbootdeveloper.DTO.ArticleResponse;
import dohoon.jun.Exam.springbootdeveloper.DTO.UpdateArticleRequest;
import dohoon.jun.Exam.springbootdeveloper.domain.Article;
import dohoon.jun.Exam.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response body 에 객체 데이터를 JSON 형태로 반환하는 컨트롤러
public class BlogApiController {
    private final BlogService blogService;
    
    // HTTP 메서드가 POST 일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    // @RequestBody로 요청 본문 값 매핑함
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
    // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    //controller 디렉터리에 있는 blogapicontroller 파일을 열어 전체 글을 조회한뒤 반환하는 findAllArticle()메서드!
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
    //@PathVariable -> URL에서 값을 가져오는 에너테이션, /api/articles/3 get요청을 받으면 id = 3 이 들어옴
     @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findByID(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request){
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}
