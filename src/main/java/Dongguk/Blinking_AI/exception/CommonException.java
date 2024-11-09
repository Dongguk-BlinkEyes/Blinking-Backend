package Dongguk.Blinking_AI.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonException extends RuntimeException {
    private final ErrorCode errorCode;
    public String getMessage() { return this.errorCode.getMessage(); }
}
