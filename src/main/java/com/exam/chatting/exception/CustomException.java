package com.exam.chatting.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException { //ErrorCode에 직접 정의한 Custom 예외를 처리할 Exception 클래스

    private final ErrorCode errorCode;

}
