package Dongguk.Blinking_Eyes.blink.domain;

import Dongguk.Blinking_Eyes.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "health_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "record_month")
    private LocalDate recordMonth;

    @OneToMany(mappedBy = "healthRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DayCount> dayCounts = new ArrayList<>();
}
