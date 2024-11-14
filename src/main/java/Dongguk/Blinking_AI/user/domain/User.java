package Dongguk.Blinking_AI.user.domain;

import Dongguk.Blinking_AI.user.dto.request.MyPageUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "prequency_alert")
    private int prequencyAlert;

    @Column(name = "display_type")
    private int displayType;

    @Column(name = "alert_type")
    private int alertType;

    public void update(MyPageUpdateRequest request){
        this.name = request.name();
        this.nickname = request.nickname();
        this.age = request.age();
        this.gender = request.gender();
        this.prequencyAlert = request.frequencyAlert();
        this.displayType = request.displayType();
        this.alertType = request.alertType();
    }
}
