package com.example.backend.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = new ApiError(
                "Ha ocurrido un error inesperado",
                status,
                java.time.LocalDateTime.now());
        return ResponseEntity
                .status(status)
                .body(apiError);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(NotFoundException e) {
        ApiError apiError = new ApiError(
                e.getMessage(),
                e.getStatus(),
                java.time.LocalDateTime.now());
        return ResponseEntity
                .status(e.getStatus())
                .body(apiError);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiError> handleConflictException(ConflictException e) {
        ApiError apiError = new ApiError(
                e.getMessage(),
                e.getStatus(),
                java.time.LocalDateTime.now());
        return ResponseEntity
                .status(e.getStatus())
                .body(apiError);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleConflictException(AccessDeniedException e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ApiError apiError = new ApiError(
                "No tiene permisos para realizar esta acción",
                status,
                java.time.LocalDateTime.now());
        return ResponseEntity
                .status(status)
                .body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleConflictException(DataIntegrityViolationException e) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ApiError apiError = new ApiError(
                e.getMessage(),
                status,
                java.time.LocalDateTime.now());
        return ResponseEntity
                .status(status)
                .body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorBadRequest> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())));
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiErrorBadRequest apiError = new ApiErrorBadRequest(
                ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage(),
                status,
                java.time.LocalDateTime.now(),
                errors);

        return ResponseEntity
                .status(status)
                .body(apiError);

    }

}
