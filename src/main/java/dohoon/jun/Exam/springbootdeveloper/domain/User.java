package dohoon.jun.Exam.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name ="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth) {
        this.email = email;
        this.password = password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() { //만료 여부 체크
        return true; // 만료 안되면 true 값 리턴
    }
    @Override
    public boolean isAccountNonLocked(){// 계정 잠김 여부 체크
        return true; // 안잠겼으면 true 값 리턴
    }
    @Override
    public boolean isCredentialsNonExpired(){ //패스워드의 만료 여부 반환
        return true; // 비밀번호 만료 안되면 true 값 리턴
    }
    @Override
    public boolean isEnabled(){ //계정 사용 여부 체크
        return true; // 계정 사용 가능시 true값 리턴
    }

}
