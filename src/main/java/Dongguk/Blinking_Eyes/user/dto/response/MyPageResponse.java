package Dongguk.Blinking_Eyes.user.dto.response;

import lombok.Builder;

@Builder
public record MyPageResponse (
    String name,
    Integer eyeSensitivity,
    Integer alarmPeriod,
    Boolean isSound
){}
