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
    public MonthlyStaticsResponse getMonthlyStatics(Long userId, LocalDate date) {
        int year = date.getYear();
        int month = date.getMonthValue();

        List<DayCount> list = dayCountRepository.findAllByMonthAndYear(year, month);
        list.sort((s1,s2)-> s1.getStartTime().compareTo(s2.getStartTime()));

        MonthlyStaticsResponse monthlyStaticsResponse = MonthlyStaticsResponse.builder()
                .month(month)
                .list(list)
                .build();

        return monthlyStaticsResponse;
    }
}
