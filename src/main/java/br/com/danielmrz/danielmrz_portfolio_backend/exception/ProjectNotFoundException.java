package br.com.danielmrz.danielmrz_portfolio_backend.exception;

public class ProjectNotFoundException extends RuntimeException {
  public ProjectNotFoundException(String message) {
    super(message);
  }
}
