package Dongguk.Blinking_Eyes.blink.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
public record TodayRecordResponse (
        Integer dayCount,
        LocalTime totalTime
){}
