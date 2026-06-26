package br.com.danielmrz.danielmrz_portfolio_backend.dto;

import java.time.LocalDateTime;

public record DefaultErrorResponse(
  String message,
  Integer statusCode,
  LocalDateTime dateTime
) {
}
