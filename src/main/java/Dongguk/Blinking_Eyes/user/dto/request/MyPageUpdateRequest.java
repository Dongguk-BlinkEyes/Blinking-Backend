package Dongguk.Blinking_Eyes.user.dto.request;

public record MyPageUpdateRequest (
    Integer eyeSensitivity,
    Integer alarmPeriod,
    Boolean isSound
){}
