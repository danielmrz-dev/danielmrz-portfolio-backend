package br.com.danielmrz.danielmrz_portfolio_backend.repository;

import br.com.danielmrz.danielmrz_portfolio_backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
