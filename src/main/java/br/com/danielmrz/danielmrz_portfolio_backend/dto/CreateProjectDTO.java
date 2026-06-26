package br.com.danielmrz.danielmrz_portfolio_backend.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectDTO(
  @NotBlank(message = "O nome é obrigatório")
  String name,

  @NotBlank(message = "O imagem é obrigatório")
  String image
) {
}
