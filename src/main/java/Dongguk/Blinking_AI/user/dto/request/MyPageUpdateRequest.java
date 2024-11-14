package Dongguk.Blinking_AI.user.dto.request;

public record MyPageUpdateRequest (
    String name,
    String nickname,
    Integer age,
    Boolean gender,
    Integer frequencyAlert,
    Integer displayType,
    Integer alertType
){}
