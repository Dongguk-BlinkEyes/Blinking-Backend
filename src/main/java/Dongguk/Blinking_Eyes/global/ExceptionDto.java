package Dongguk.Blinking_Eyes.global;


import Dongguk.Blinking_Eyes.exception.ErrorCode;

public record ExceptionDto(
        Integer code,
        String message
) {
    public ExceptionDto(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public static ExceptionDto of(ErrorCode errorCode) {
        return new ExceptionDto(errorCode);
    }
}