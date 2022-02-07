package com.bilitech.yilimusic.handler;

import com.bilitech.yilimusic.exception.BizException;
import com.bilitech.yilimusic.exception.ErrorResponse;
import com.bilitech.yilimusic.exception.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse bizExceptionHandler(BizException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(e.getCode());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTrace(e.getStackTrace());
        return errorResponse;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse exceptionHandler(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionType.INNER_ERROR.getCode());
        errorResponse.setMessage(ExceptionType.INNER_ERROR.getMessage());
        return errorResponse;
    }


    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse accessDeniedHandler(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionType.FORBIDDEN.getCode());
        errorResponse.setMessage(ExceptionType.FORBIDDEN.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorResponse> bizExceptionHandler(MethodArgumentNotValidException e) {
        List<ErrorResponse> errorResponses = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode(ExceptionType.BAD_REQUEST.getCode());
            errorResponse.setMessage(error.getDefaultMessage());
            errorResponses.add(errorResponse);
        });
        return errorResponses;
    }
}
