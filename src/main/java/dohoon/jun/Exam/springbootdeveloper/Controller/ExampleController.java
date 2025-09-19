package dohoon.jun.Exam.springbootdeveloper.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;



@Controller
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model){ //뷰로 데이터 넘겨줌
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("전도훈");
        examplePerson.setAge(30);
        examplePerson.setHobbies(List.of("운동", "독서"));

        model.addAttribute("person", examplePerson); //person 객체의 저장
        model.addAttribute("today", LocalDate.now());

        return "example"; // example.html라는 뷰 조회

    }
    @Setter
    @Getter
    class Person{
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}
