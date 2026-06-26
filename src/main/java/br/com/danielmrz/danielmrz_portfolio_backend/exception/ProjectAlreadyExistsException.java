package br.com.danielmrz.danielmrz_portfolio_backend.exception;

public class ProjectAlreadyExistsException extends RuntimeException {
  public ProjectAlreadyExistsException(String message) {
    super(message);
  }
}
