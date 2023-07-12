package com.appcoy.school.management.api.handler;

import com.appcoy.school.management.api.app.BaseResponse;
import com.appcoy.school.management.api.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GenericResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final Mono<ResponseEntity<BaseResponse<Object>>> handleNotFoundException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(BaseResponse.notFoundResponse(ex.getMessage()));
    }
}
