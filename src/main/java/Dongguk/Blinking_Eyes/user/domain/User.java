package Dongguk.Blinking_Eyes.user.domain;

import Dongguk.Blinking_Eyes.blink.domain.HealthRecord;
import Dongguk.Blinking_Eyes.user.dto.request.MyPageUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "eye_sensitivity")
    private int eyeSensitivity;

    @Column(name = "alarm_period")
    private int alarmPeriod;

    @Column(name = "is_sound")
    private boolean isSound;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<HealthRecord> healthRecords = new ArrayList<>();

    public void update(MyPageUpdateRequest request){
        this.eyeSensitivity = request.eyeSensitivity();
        this.alarmPeriod = request.alarmPeriod();
        this.isSound = request.isSound();
    }
}
