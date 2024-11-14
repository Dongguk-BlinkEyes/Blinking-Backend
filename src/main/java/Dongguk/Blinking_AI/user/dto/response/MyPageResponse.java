package Dongguk.Blinking_AI.user.dto.response;

import lombok.Builder;

@Builder
public record MyPageResponse (
    String nickname,
    Integer age,
    Boolean gender,
    Integer frequencyAlert,
    Integer displayType,
    Integer alertType
){}
