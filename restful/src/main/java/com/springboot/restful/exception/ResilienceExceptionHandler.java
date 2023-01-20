package com.springboot.restful.exception;

import com.springboot.restful.controller.FeedController;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(assignableTypes = {FeedController.class})
public class ResilienceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CallNotPermittedException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public void handleCallNotPermittedException() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException() {
    }
}
