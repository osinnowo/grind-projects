package com.appcoy.school.management.api.app;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseResponse<T> {
    private Boolean status;
    private String message;
    private T data;

    private static final Boolean OK = true;
    static class BaseResponseMessage {
        private static final String SUCCESSFUL = "Successful";
        private static final String FAILED = "Failed";
    }
    public static<T> BaseResponse<T> ok(String message, T data) {
        return new BaseResponse<T>(OK, message, data);
    }
    public static<T> BaseResponse<T> ok(T data) {
        return ok(BaseResponseMessage.SUCCESSFUL, data);
    }
    public static<T> BaseResponse<T> ok() {
        return ok(null);
    }
    public static<T> ResponseEntity<BaseResponse<T>> okResponse(String message, T data) {
        return ResponseEntity.ok(ok(message, data));
    }
    public static<T> ResponseEntity<BaseResponse<T>> okResponse(T data) {
        return ResponseEntity.ok(ok(data));
    }
    public static<T> ResponseEntity<BaseResponse<T>> okResponse() {
        return ResponseEntity.ok(ok());
    }
    public static<T> BaseResponse<T> notFound(String message) {
        return new BaseResponse<T>(false, message, null);
    }
    public static<T> ResponseEntity<BaseResponse<T>> notFoundResponse(String message) {
        return new ResponseEntity<BaseResponse<T>>(notFound(message), HttpStatus.NOT_FOUND);
    }
}
