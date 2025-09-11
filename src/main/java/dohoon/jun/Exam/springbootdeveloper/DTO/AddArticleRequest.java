package dohoon.jun.Exam.springbootdeveloper.DTO;


//계층끼리 데이터 교환을 위한 객체 (단순 데이터를 주고받기 위한 역할이라 로직이 크게 필요하지 않음)

import dohoon.jun.Exam.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    //toEntity 메서드는 빌더패턴을 사용하여 DTO를 엔티티로 만들어주는 메서드
    public Article toEntity(){ //생성자를 사용해 객체를 생성함
        return Article.builder().title(title).content(content).build();
    }
}
