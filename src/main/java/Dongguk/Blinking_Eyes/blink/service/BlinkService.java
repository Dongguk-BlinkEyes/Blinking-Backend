package Dongguk.Blinking_Eyes.blink.service;

import Dongguk.Blinking_Eyes.blink.domain.DayCount;
import Dongguk.Blinking_Eyes.blink.dto.response.MonthlyStaticsResponse;
import Dongguk.Blinking_Eyes.blink.dto.response.TodayRecordResponse;
import Dongguk.Blinking_Eyes.blink.repository.DayCountRepository;
import Dongguk.Blinking_Eyes.blink.repository.HealthRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlinkService {

    private final HealthRecordRepository healthRecordRepository;
    private final DayCountRepository dayCountRepository;

    @Transactional(readOnly = true)
    public TodayRecordResponse getTodayRecord(Long userId) {
        LocalDate now = LocalDate.now();
        List<DayCount> list = dayCountRepository.findAllByDayCountDate(now);

        int totalCount = 0;
        Duration totalDuration = Duration.ZERO;

        for (DayCount dayCount : list) {
            LocalDateTime start = dayCount.getStartTime();
            LocalDateTime end = dayCount.getEndTime();

            if (start == null || end == null) {
                throw new IllegalArgumentException("xxx");
            }

            Duration duration = Duration.between(start, end);
            totalDuration = totalDuration.plus(duration);

            totalCount += dayCount.getDayCount();
        }

        long totalSeconds = totalDuration.getSeconds();
        LocalTime totalTime = LocalTime.ofSecondOfDay(totalSeconds);

        TodayRecordResponse todayRecordResponse = TodayRecordResponse.builder()
                .dayCount(totalCount)
                .totalTime(totalTime)
                .build();

        return todayRecordResponse;
    }

    @Transactional(readOnly = true)
    public MonthlyStaticsResponse getMonthlyStatics(Long userId){
        //구현해야함
    }
}
