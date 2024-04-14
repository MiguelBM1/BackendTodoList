package com.example.backend.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError(String message, HttpStatus status, LocalDateTime timestamp) {
}
