package br.com.danielmrz.danielmrz_portfolio_backend.dto;

import br.com.danielmrz.danielmrz_portfolio_backend.model.Technologies;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateProjectDTO(
  @NotBlank(message = "O nome é obrigatório")
  String name,

  @NotBlank(message = "A imagem é obrigatória")
  String image,

  @NotBlank(message = "O link do repositório é obrigatório")
  String repositoryLink,

  @NotBlank(message = "O link do projeto em produção é obrigatório")
  String liveSiteLink,

  @NotEmpty(message = "Pelo menos uma tecnologia é obrigatória")
  List<Technologies> technologies
) {
}
