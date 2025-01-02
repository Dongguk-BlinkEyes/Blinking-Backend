package Dongguk.Blinking_Eyes.blink.dto.response;

import Dongguk.Blinking_Eyes.blink.domain.DayCount;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record MonthlyStaticsResponse (
        int month,
        List<DayCount> list
){}
